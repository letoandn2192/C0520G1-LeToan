package controller;

import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private ServiceBO serviceBO = new ServiceBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editServiceInfo(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "create":
                createService(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                showServiceInformation(request, response);
                break;
            case "edit":
                showServiceEditForm(request, response);
                break;
            case "delete":
                showServiceDeleteForm(request, response);
                break;
            case "create":
                showServiceCreateForm(request, response);
                break;
            case "search":
                showServiceSearch(request, response);
                break;
            default:
                showServiceList(request, response);
                break;
        }
    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        int start, offset = 5, page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int totalRecord = serviceBO.getCountService();
        int totalPage = totalRecord / offset;
        if (totalRecord % offset != 0) {
            totalPage = totalPage + 1;
        }

        if (totalRecord <= 5) {
            start = 0;
            offset = totalRecord;
        } else {
            start = (page - 1) * 5;
        }
        List<Service> serviceList = serviceBO.getServiceByPage(start, offset);
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("totalPage", totalPage);
        try {
            request.getRequestDispatcher("view/service/service-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/view/service/service-create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceInformation(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found!!!");
        } else {
            request.setAttribute("service", service);
        }
        try {
            request.getRequestDispatcher("/view/service/service-detail.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("service", service);
        }
        try {
            request.getRequestDispatcher("/view/service/service-edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editServiceInfo(HttpServletRequest request, HttpServletResponse response) {
        String  id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            service.setServiceName(request.getParameter("name"));
            service.setServiceArea(Double.parseDouble(request.getParameter("area")));
            service.setServiceCost(Double.parseDouble(request.getParameter("cost")));
            service.setServiceMaxPerson(Integer.parseInt(request.getParameter("maxPerson")));
            service.setRentTypeId(Integer.parseInt(request.getParameter("rentType")));
            service.setServiceTypeId(Integer.parseInt(request.getParameter("serviceType")));
            service.setStandardRoom(request.getParameter("standard"));
            service.setDescription(request.getParameter("description"));
            service.setPoolArea(Double.parseDouble(request.getParameter("pool")));
            service.setNumberFloor(Integer.parseInt(request.getParameter("floor")));

            serviceBO.editServiceInfo(service);
            request.setAttribute("service", service);
            try {
                request.getRequestDispatcher("/view/service/service-detail.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showServiceDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("service", service);
        }
        try {
            request.getRequestDispatcher("/view/service/service-delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            serviceBO.deleteService(id);
        }
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPerson = Integer.parseInt(request.getParameter("maxPerson"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        if (serviceType == 1) {
            String standard = request.getParameter("standard");
            String description = request.getParameter("description");
            double pool = Double.parseDouble(request.getParameter("pool"));
            int floor = Integer.parseInt(request.getParameter("floor"));
            serviceBO.create(new Service(id, name, area, cost, maxPerson, rentType, serviceType, standard, description, pool, floor));
        } else if (serviceType == 2) {
            String standard = request.getParameter("standard");
            String description = request.getParameter("description");
            int floor = Integer.parseInt(request.getParameter("floor"));
            serviceBO.create(new Service(id, name, area, cost, maxPerson, rentType, serviceType, standard, description, floor));
        } else {
            serviceBO.create(new Service(id, name, area, cost, maxPerson, rentType, serviceType));
        }
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList;
        String search = request.getParameter("search");
        String action = request.getParameter("action");
        serviceList = serviceBO.search(search);
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("search", search);
        request.setAttribute("action", action);
        try {
            request.getRequestDispatcher("/view/service/service-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
