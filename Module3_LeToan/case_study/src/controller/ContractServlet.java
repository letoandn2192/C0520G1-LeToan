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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            case "manager":
                showManagerContract(request, response);
                break;
            default:
                showContractList(request, response);
                break;
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
//        int start, offset = 5, page = 1;
//
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        int totalRecord = contractBO.getCountContract();
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
//        List<Contract> contractList = contractBO.getContractByPage(start, offset);
//        request.setAttribute("contractList", contractList);
//        request.setAttribute("totalPage", totalPage);
        List<Contract> contractList = contractBO.findAllContract();
        request.setAttribute("contractList", contractList);
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
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String deposit = request.getParameter("deposit");
        String totalMoney = request.getParameter("totalMoney");
        String employeeId = request.getParameter("employeeId");
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        List<String> errMessList = contractBO.checkValidateContract(startDate, endDate, deposit, totalMoney);
        if (errMessList.isEmpty()) {
            contractBO.create(new Contract(startDate, endDate, Double.parseDouble(deposit), Double.parseDouble(totalMoney), employeeId, customerId, serviceId));
            request.setAttribute("messageInform", "Create Successful !!!");
            showContractList(request, response);
        } else {
            request.setAttribute("errMessList", errMessList);
            request.setAttribute("employeeList", employeeBO.findAllEmployee());
            request.setAttribute("customerList", customerBO.findAllCustomer());
            request.setAttribute("serviceList", serviceBO.findAllService());
            try {
                request.getRequestDispatcher("view/contract/contract-create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
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
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String deposit = request.getParameter("deposit");
            String totalMoney = request.getParameter("totalMoney");
            contract.setEmployeeId(request.getParameter("employeeId"));
            contract.setCustomerId(request.getParameter("customerId"));
            contract.setServiceId(request.getParameter("serviceId"));
            request.setAttribute("contract", contract);
            List<String> errMessList = contractBO.checkValidateContract(startDate, endDate, deposit, totalMoney);
            if (errMessList.isEmpty()) {
                contract.setContractStartDate(startDate);
                contract.setContractEndDate(startDate);
                contract.setContractDeposit(Double.parseDouble(deposit));
                contract.setContractTotalMoney(Double.parseDouble(totalMoney));
                contractBO.editContractInfo(contract);
                request.setAttribute("messageInform", "Update Successful !!!");
                try {
                    request.getRequestDispatcher("view/contract/contract-detail.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("errMessList", errMessList);
                request.setAttribute("employeeList", employeeBO.findAllEmployee());
                request.setAttribute("customerList", customerBO.findAllCustomer());
                request.setAttribute("serviceList", serviceBO.findAllService());
                try {
                    request.getRequestDispatcher("view/contract/contract-edit.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
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
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            contractBO.deleteContract(id);
            request.setAttribute("messageInform", "Delete Successful !!!");
        }
        showContractList(request, response);
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

    private void showManagerContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractBO.managerContract();
        request.setAttribute("contractList", contractList);
        try {
            request.getRequestDispatcher("/view/contract/contract-manager.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
