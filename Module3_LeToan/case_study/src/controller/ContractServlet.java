package controller;

import bo.contract_bo.ContractBO;
import bo.contract_bo.ContractBOImpl;
import bo.cutomer_bo.CustomerBO;
import bo.cutomer_bo.CustomerBOImpl;
import bo.employee_bo.EmployeeBO;
import bo.employee_bo.EmployeeBOImpl;
import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private ContractBO contractBO = new ContractBOImpl();
    private EmployeeBO employeeBO = new EmployeeBOImpl();
    private CustomerBO customerBO = new CustomerBOImpl();
    private ServiceBO serviceBO = new ServiceBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editContractInfo(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "create":
                createContract(request, response);
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
                showContractInformation(request, response);
                break;
            case "edit":
                showContractEditForm(request, response);
                break;
            case "delete":
                showContractDeleteForm(request, response);
                break;
            case "create":
                showContractCreateForm(request, response);
                break;
            case "search":
                showContractSearch(request, response);
                break;
            default:
                showContractList(request, response);
                break;
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        int start, offset = 5, page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int totalRecord = contractBO.getCountContract();
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
        List<Contract> contractList = contractBO.getContractByPage(start, offset);
        request.setAttribute("contractList", contractList);
        request.setAttribute("totalPage", totalPage);
        try {
            request.getRequestDispatcher("view/contract/contract-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("employeeList", employeeBO.findAllEmployee());
            request.setAttribute("customerList", customerBO.findAllCustomer());
            request.setAttribute("serviceList", serviceBO.findAllService());
            request.getRequestDispatcher("/view/contract/contract-create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        String employeeId = request.getParameter("employeeId");
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");

        contractBO.create(new Contract(startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId));
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractInformation(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found!!!");
        } else {
            request.setAttribute("contract", contract);
        }
        try {
            request.getRequestDispatcher("/view/contract/contract-detail.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("contract", contract);
            request.setAttribute("employeeList", employeeBO.findAllEmployee());
            request.setAttribute("customerList", customerBO.findAllCustomer());
            request.setAttribute("serviceList", serviceBO.findAllService());
        }
        try {
            request.getRequestDispatcher("/view/contract/contract-edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editContractInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            contract.setContractStartDate(Date.valueOf(request.getParameter("startDate")));
            contract.setContractEndDate(Date.valueOf(request.getParameter("endDate")));
            contract.setContractDeposit(Double.parseDouble(request.getParameter("deposit")));
            contract.setContractTotalMoney(Double.parseDouble(request.getParameter("totalMoney")));
            contract.setEmployeeId(request.getParameter("employeeId"));
            contract.setCustomerId(request.getParameter("customerId"));
            contract.setServiceId(request.getParameter("serviceId"));

            contractBO.editContractInfo(contract);
            request.setAttribute("contract", contract);
            try {
                request.getRequestDispatcher("/view/contract/contract-detail.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showContractDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("contract", contract);
        }
        try {
            request.getRequestDispatcher("/view/contract/contract-delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            contractBO.deleteContract(id);
        }
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList;
        String search = request.getParameter("search");
        String action = request.getParameter("action");
        contractList = contractBO.search(search);
        request.setAttribute("contractList", contractList);
        request.setAttribute("search", search);
        request.setAttribute("action", action);
        try {
            request.getRequestDispatcher("/view/contract/contract-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
