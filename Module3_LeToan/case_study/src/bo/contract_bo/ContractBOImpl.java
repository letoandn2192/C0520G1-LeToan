package bo.contract_bo;

import bo.common_bo.Regex;
import dao.contract_dao.ContractDAO;
import dao.contract_dao.ContractDAOImpl;
import model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractBOImpl implements ContractBO {
    private ContractDAO contractDAO = new ContractDAOImpl();

    @Override
    public List<Contract> findAllContract() {
        return contractDAO.findAllContract();
    }

    @Override
    public Contract findContractById(int id) {
        return contractDAO.findContractById(id);
    }

    @Override
    public void create(Contract contract) {
        contractDAO.create(contract);
    }

    @Override
    public boolean editContractInfo(Contract contract) {
        return contractDAO.editContractInfo(contract);
    }

    @Override
    public boolean deleteContract(int id) {
        return contractDAO.deleteContract(id);
    }

    @Override
    public List<Contract> search(String search) {
        return contractDAO.search(search);
    }

    @Override
    public List<Contract> getContractByPage(int start, int offset) {
        return contractDAO.getContractByPage(start, offset);
    }

    @Override
    public int getCountContract() {
        return contractDAO.getCountContract();
    }

    @Override
    public List<Contract> managerContract() {
        return contractDAO.managerContract();
    }

    @Override
    public List<String> checkValidateContract(String startDate, String endDate, String deposit, String totalMoney) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateStartDate = Regex.checkValidateDate(startDate);
        boolean checkValidateEndDate = Regex.checkValidateDate(endDate);
        boolean checkValidateDeposit = Regex.checkRegexDoublePositive(deposit);
        boolean checkValidateTotalMoney = Regex.checkRegexDoublePositive(totalMoney);
        if (!(checkValidateStartDate && checkValidateEndDate && checkValidateDeposit && checkValidateTotalMoney)) {
            if (!checkValidateStartDate) {
                errMessList.add("Date Format dd/mm/yyyy");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEndDate) {
                errMessList.add("Date Format dd/mm/yyyy");
            } else {
                errMessList.add("");
            }
            if (!checkValidateDeposit) {
                errMessList.add("Deposit must be positive Number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateTotalMoney) {
                errMessList.add("Total money must be positive Number");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }
}
