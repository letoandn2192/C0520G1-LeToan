package controller;

import bo.cutomer_bo.CustomerBO;
import bo.cutomer_bo.CustomerBOImpl;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO = new CustomerBOImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editCustomerInfo(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "create":
                createCustomer(request, response);
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
                showCustomerInformation(request, response);
                break;
            case "edit":
                showCustomerEditForm(request, response);
                break;
            case "delete":
                showCustomerDeleteForm(request, response);
                break;
            case "create":
                showCustomerCreateForm(request, response);
                break;
            case "search":
                showCustomerSearch(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }

    private void showCustomerList (HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerBO.findAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/customer-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerInformation(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("messageInform", "Not Found!!!");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("/view/customer/customer-detail.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("/view/customer/customer-edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
        String  id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            customer.setCustomerTypeId(Integer.parseInt(request.getParameter("typeId")));
            customer.setCustomerName(request.getParameter("name"));
            String birthday = request.getParameter("birthday");
            customer.setCustomerGender(Integer.parseInt(request.getParameter("gender")));
            String idNumber = request.getParameter("idNumber");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            customer.setCustomerAddress(request.getParameter("address"));

            List<String> errMessList = customerBO.checkValidateCustomer(birthday, idNumber, phone, email);
            if (errMessList.isEmpty()) {
                customer.setCustomerBirthday(birthday);
                customer.setCustomerIdCard(idNumber);
                customer.setCustomerPhone(phone);
                customer.setCustomerEmail(email);
                customerBO.editCustomerInfo(customer);
                request.setAttribute("messageInform", "Update Successful !!!");
                request.setAttribute("customer", customer);
                try {
                    request.getRequestDispatcher("/view/customer/customer-detail.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("customer", customer);
                request.setAttribute("errMessList", errMessList);
                try {
                    request.getRequestDispatcher("/view/customer/customer-edit.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showCustomerDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("/view/customer/customer-delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            customerBO.deleteCustomer(id);
            request.setAttribute("messageInform", "Delete Successful !!!");
        }
        showCustomerList(request, response);
    }

    private void showCustomerCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/view/customer/customer-create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idNumber = request.getParameter("idNumber");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        List<String> errMessList = customerBO.checkValidateCustomer(id, birthday, idNumber, phone, email);
        if (errMessList.isEmpty()) {
            Customer customer = new Customer(id, name, birthday, gender, idNumber, phone, email, address, typeId);
            customerBO.create(customer);
            request.setAttribute("messageInform", "Create Successful !!!");
            showCustomerList(request, response);
        } else {
            request.setAttribute("errMessList", errMessList);
            try {
                request.getRequestDispatcher("/view/customer/customer-create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCustomerSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList;
        String search = request.getParameter("search");
        String action = request.getParameter("action");
        customerList = customerBO.search(search);
        request.setAttribute("customerList", customerList);
        request.setAttribute("search", search);
        request.setAttribute("action", action);
        try {
            request.getRequestDispatcher("/view/customer/customer-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
