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
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
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
        int start, offset = 5, page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int totalRecord = customerBO.getCountCustomer();
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
        List<Customer> customerList = customerBO.getCustomerByPage(start, offset);
        request.setAttribute("customerList", customerList);
        request.setAttribute("totalPage", totalPage);
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
            request.setAttribute("message", "Not Found!!!");
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
            request.setAttribute("message", "Not Found !!!");
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
            customer.setCustomerBirthday( Date.valueOf(request.getParameter("birthday")));
            customer.setCustomerGender(Integer.parseInt(request.getParameter("gender")));
            customer.setCustomerIdCard(request.getParameter("idNumber"));
            customer.setCustomerPhone(request.getParameter("phone"));
            customer.setCustomerEmail(request.getParameter("email"));
            customer.setCustomerAddress(request.getParameter("address"));

            customerBO.editCustomerInfo(customer);
            request.setAttribute("customer", customer);
            try {
                request.getRequestDispatcher("/view/customer/customer-detail.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCustomerDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found !!!");
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
            request.setAttribute("message", "Not Found !!!");
        } else {
            customerBO.deleteCustomer(id);
        }
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idNumber = request.getParameter("idNumber");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        boolean validateId = customerBO.checkValidateCustomerId(id);
        boolean validateIdCard = customerBO.checkValidateCustomerIdNumber(idNumber);
        boolean validatePhone = customerBO.checkValidatePhoneNumber(phone);
        boolean validateEmail = customerBO.checkValidateEmail(email);
        if (validateId && validatePhone && validateEmail && validateIdCard) {
            Customer customer = new Customer(id, name, birthday, gender, idNumber, phone, email, address, typeId);
            customerBO.create(customer);
            request.setAttribute("messageInform", "Create Successful !!!");
            showCustomerList(request,response);
        } else {
            if (!validateId) {
                request.setAttribute("messageId", "Customer ID format KH-XXXX (X from 0-9)");
            }
            if (!validatePhone) {
                request.setAttribute("messagePhone", "Phone number format...");
            }
            if (!validateEmail) {
                request.setAttribute("messageEmail", "Email format abc@abc.abc");
            }
            if (!validateIdCard) {
                request.setAttribute("messageIdCard", "Id Card format XXXXXXXXX (X from 0-9)");
            }
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
