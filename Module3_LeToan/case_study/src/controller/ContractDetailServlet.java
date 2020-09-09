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
import java.util.List;

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
            request.setAttribute("messageInform", "Not Found !!!");
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
        Contract contract = contractBO.findContractById(contractId);
        if (contract == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            int attachServiceId = Integer.parseInt(request.getParameter("attachService"));
            String quantity = request.getParameter("quantity");
            List<String> errMessList = contractDetailBO.checkValidateContractDetail(quantity);
            request.setAttribute("contract", contract);
            if (errMessList.isEmpty()) {
                ContractDetail contractDetail = new ContractDetail(contractId, attachServiceId, Integer.parseInt(quantity));
                contractDetailBO.create(contractDetail);
                try {
                    request.getRequestDispatcher("/view/contract/contract-detail.jsp").forward(request, response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("errMessList", errMessList);
                try {
                    request.getRequestDispatcher("/view/contract_detail/contract-detail-create.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
