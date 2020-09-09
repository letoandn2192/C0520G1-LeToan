package bo.contract_detail_bo;

import bo.common_bo.Regex;
import dao.contract_detail_dao.ContractDetailDAO;
import dao.contract_detail_dao.ContractDetailDAOImpl;
import model.ContractDetail;

import java.util.ArrayList;
import java.util.List;

public class ContractDetailBOImpl implements ContractDetailBO {
    private ContractDetailDAO contractDetailDAO = new ContractDetailDAOImpl();
    @Override
    public void create(ContractDetail contractDetail) {
        contractDetailDAO.create(contractDetail);
    }

    @Override
    public List<String> checkValidateContractDetail(String quantity) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateQuantity = Regex.checkRegexIntegerPositive(quantity);
        if (!checkValidateQuantity) {
            errMessList.add("Quantity must be positive number");
        }
        return errMessList;
    }
}
