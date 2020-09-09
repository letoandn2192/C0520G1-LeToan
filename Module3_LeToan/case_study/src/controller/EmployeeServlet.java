package controller;

import bo.employee_bo.EmployeeBO;
import bo.employee_bo.EmployeeBOImpl;
import model.Customer;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editEmployeeInfo(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "create":
                createEmployee(request, response);
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
                showEmployeeInformation(request, response);
                break;
            case "edit":
                showEmployeeEditForm(request, response);
                break;
            case "delete":
                showEmployeeDeleteForm(request, response);
                break;
            case "create":
                showEmployeeCreateForm(request, response);
                break;
            case "search":
                showEmployeeSearch(request, response);
                break;
            default:
                showEmployeeList(request, response);
                break;
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
//        int start, offset = 5, page = 1;
//
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        int totalRecord = employeeBO.getCountEmployee();
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
//        List<Employee> employeeList = employeeBO.getEmployeeByPage(start, offset);
//        request.setAttribute("employeeList", employeeList);
//        request.setAttribute("totalPage", totalPage);
        List<Employee> employeeList = employeeBO.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("view/employee/employee-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeInformation(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found!!!");
        } else {
            request.setAttribute("employee", employee);
        }
        try {
            request.getRequestDispatcher("/view/employee/employee-detail.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("employee", employee);
        }
        try {
            request.getRequestDispatcher("/view/employee/employee-edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployeeInfo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            employee.setEmployeeName(request.getParameter("name"));
            String birthday = request.getParameter("birthday");
            String idNumber = request.getParameter("idNumber");
            String salary = request.getParameter("salary");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            employee.setEmployeeAddress(request.getParameter("address"));
            employee.setPositionId(Integer.parseInt(request.getParameter("position")));
            employee.setEducationDegreeId(Integer.parseInt(request.getParameter("education")));
            employee.setDivisionId(Integer.parseInt(request.getParameter("division")));
            employee.setUserName(request.getParameter("username"));
            List<String> errMessList = employeeBO.checkValidateEmployee(birthday, idNumber, salary, phone, email);
            if (errMessList.isEmpty()) {
                employee.setEmployeeBirthday(request.getParameter("birthday"));
                employee.setEmployeeIdCard(request.getParameter("idNumber"));
                employee.setEmployeeSalary(Double.parseDouble(request.getParameter("salary")));
                employee.setEmployeePhone(request.getParameter("phone"));
                employee.setEmployeeEmail(request.getParameter("email"));
                employeeBO.editEmployeeInfo(employee);
                request.setAttribute("messageInform", "Update Successful");
                request.setAttribute("employee", employee);
                try {
                    request.getRequestDispatcher("/view/employee/employee-detail.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("employee", employee);
                request.setAttribute("errMessList", errMessList);
                try {
                    request.getRequestDispatcher("/view/employee/employee-edit.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showEmployeeDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("employee", employee);
        }
        try {
            request.getRequestDispatcher("/view/employee/employee-delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            employeeBO.deleteEmployee(id);
            request.setAttribute("messageInform", "Delete Successful");
        }
        showEmployeeList(request, response);
    }

    private void showEmployeeCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/view/employee/employee-create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idNumber = request.getParameter("idNumber");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        List<String> errMessList = employeeBO.checkValidateEmployee(id, birthday, idNumber, salary, phone, email);
        if (errMessList.isEmpty()) {
            Employee employee = new Employee(id, name, birthday, idNumber, Double.parseDouble(salary), phone, email, address, position, education, division, username);
            employeeBO.create(employee);
            request.setAttribute("messageInform", "Create Successful !!!");
            showEmployeeList(request, response);
        } else {
            request.setAttribute("errMessList", errMessList);
            try {
                request.getRequestDispatcher("/view/employee/employee-create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showEmployeeSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList;
        String search = request.getParameter("search");
        String action = request.getParameter("action");
        employeeList = employeeBO.search(search);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("search", search);
        request.setAttribute("action", action);
        try {
            request.getRequestDispatcher("/view/employee/employee-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
