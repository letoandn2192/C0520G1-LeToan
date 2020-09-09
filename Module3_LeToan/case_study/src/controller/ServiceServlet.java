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
import java.util.ArrayList;
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
//        int start, offset = 5, page = 1;
//
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        int totalRecord = serviceBO.getCountService();
//        int totalPage = totalRecord / offset;
//        if (totalRecord % offset != 0) {
//            totalPage = totalPage + 1;
//        }
//
//        if (totalRecord <= 5) {
//            start = 0;
//            offset = totalRecord;
//        } else {
//            start = (page - 1) * 5;
//        }
//        List<Service> serviceList = serviceBO.getServiceByPage(start, offset);
//        request.setAttribute("serviceList", serviceList);
//        request.setAttribute("totalPage", totalPage);
        List<Service> serviceList = serviceBO.findAllService();
        request.setAttribute("serviceList", serviceList);
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
            request.setAttribute("messageInform", "Not Found!!!");
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
            request.setAttribute("messageInform", "Not Found !!!");
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
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            service.setServiceName(request.getParameter("name"));
            String area = request.getParameter("area");
            String cost = request.getParameter("cost");
            String maxPerson = request.getParameter("maxPerson");
            service.setRentTypeId(Integer.parseInt(request.getParameter("rentType")));
            service.setServiceTypeId(Integer.parseInt(request.getParameter("serviceType")));
            service.setStandardRoom(request.getParameter("standard"));
            service.setDescription(request.getParameter("description"));
            int serviceType = Integer.parseInt(request.getParameter("serviceType"));
            List<String> errMessList;
            if (serviceType == 1) {
                String poolArea = request.getParameter("pool");
                String numberFloor = request.getParameter("floor");
                errMessList = serviceBO.checkValidateService(area, cost, maxPerson, poolArea, numberFloor);
                if (errMessList.isEmpty()) {
                    service.setServiceArea(Double.parseDouble(area));
                    service.setServiceCost(Double.parseDouble(cost));
                    service.setServiceMaxPerson(Integer.parseInt(maxPerson));
                    service.setPoolArea(Double.parseDouble(poolArea));
                    service.setServiceMaxPerson(Integer.parseInt(numberFloor));
                    serviceBO.editServiceInfo(service);
                    request.setAttribute("service", service);
                    request.setAttribute("messageInform", "Edit Successful !!!");
                    try {
                        request.getRequestDispatcher("/view/service/service-detail.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (serviceType == 2) {
                String numberFloor = request.getParameter("floor");
                errMessList = serviceBO.checkValidateService(area, cost, maxPerson, "1", numberFloor);
                if (errMessList.isEmpty()) {
                    service.setServiceArea(Double.parseDouble(area));
                    service.setServiceCost(Double.parseDouble(cost));
                    service.setServiceMaxPerson(Integer.parseInt(maxPerson));
                    service.setNumberFloor(Integer.parseInt(numberFloor));
                    serviceBO.editServiceInfo(service);
                    request.setAttribute("service", service);
                    request.setAttribute("messageInform", "Edit Successful !!!");
                    try {
                        request.getRequestDispatcher("/view/service/service-detail.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                errMessList = serviceBO.checkValidateService(area, cost, maxPerson, "1", "1");
                if (errMessList.isEmpty()) {
                    service.setServiceArea(Double.parseDouble(area));
                    service.setServiceCost(Double.parseDouble(cost));
                    service.setServiceMaxPerson(Integer.parseInt(maxPerson));
                    serviceBO.editServiceInfo(service);
                    request.setAttribute("service", service);
                    request.setAttribute("messageInform", "Edit Successful !!!");
                    try {
                        request.getRequestDispatcher("/view/service/service-detail.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!errMessList.isEmpty()) {
                request.setAttribute("errMessList", errMessList);
                request.setAttribute("service", service);
                try {
                    request.getRequestDispatcher("/view/service/service-edit.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showServiceDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceBO.findServiceById(id);
        if (service == null) {
            request.setAttribute("messageInform", "Not Found !!!");
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
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            serviceBO.deleteService(id);
            request.setAttribute("messageInform", "Delete Successful !!!");
        }
        showServiceList(request, response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        List<String> errMessList = new ArrayList<>();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String cost = request.getParameter("cost");
        String maxPerson = request.getParameter("maxPerson");
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        if (serviceType == 1) {
            String standard = request.getParameter("standard");
            String description = request.getParameter("description");
            String pool = request.getParameter("pool");
            String floor = request.getParameter("floor");
            errMessList = serviceBO.checkValidateService(id, area, cost, maxPerson, pool, floor);
            if (errMessList.isEmpty()) {
                serviceBO.create(new Service(id, name, Double.parseDouble(area), Double.parseDouble(cost), Integer.parseInt(maxPerson),
                        rentType, serviceType, standard, description, Double.parseDouble(pool), Integer.parseInt(floor)));
                request.setAttribute("messageInform", "Create Successful !!!");
                showServiceList(request, response);
            }
        } else if (serviceType == 2) {
            String standard = request.getParameter("standard");
            String description = request.getParameter("description");
            String floor = request.getParameter("floor");
            errMessList = serviceBO.checkValidateService(id, area, cost, maxPerson, "1", floor);
            if (errMessList.isEmpty()) {
                serviceBO.create(new Service(id, name, Double.parseDouble(area), Double.parseDouble(cost), Integer.parseInt(maxPerson),
                        rentType, serviceType, standard, description, Integer.parseInt(floor)));
                request.setAttribute("messageInform", "Create Successful !!!");
                showServiceList(request, response);
            }
        } else {
            errMessList = serviceBO.checkValidateService(id, area, cost, maxPerson, "1", "1");
            if (errMessList.isEmpty()) {
                serviceBO.create(new Service(id, name, Double.parseDouble(area), Double.parseDouble(cost), Integer.parseInt(maxPerson),
                        rentType, serviceType));
                request.setAttribute("messageInform", "Create Successful !!!");
                showServiceList(request, response);
            }
        }
        if (!errMessList.isEmpty()) {
            request.setAttribute("errMessList", errMessList);
            try {
                request.getRequestDispatcher("/view/service/service-create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
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
