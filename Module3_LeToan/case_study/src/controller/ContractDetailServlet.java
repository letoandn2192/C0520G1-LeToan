package controller;

import bo.contract_bo.ContractBO;
import bo.contract_bo.ContractBOImpl;
import bo.contract_detail_bo.ContractDetailBO;
import bo.contract_detail_bo.ContractDetailBOImpl;
import model.Contract;
import model.ContractDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contract_detail")
public class ContractDetailServlet extends HttpServlet {
    private ContractBO contractBO = new ContractBOImpl();
    private ContractDetailBO contractDetailBO = new ContractDetailBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
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
            case "create":
                createContractDetailForm(request, response);
                break;
            default:
                break;
        }
    }

    private void createContractDetailForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractBO.findContractById(id);
        if (contract == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("contract", contract);
        }
        try {
            request.getRequestDispatcher("/view/contract_detail/contract-detail-create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachService"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contractId, attachServiceId, quantity);
        contractDetailBO.create(contractDetail);
        try {
            Contract contract = contractBO.findContractById(contractId);
            request.setAttribute("contract", contract);
            request.getRequestDispatcher("/view/contract/contract-detail.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
