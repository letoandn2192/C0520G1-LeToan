package bo.contract_bo;

import dao.contract_dao.ContractDAO;
import dao.contract_dao.ContractDAOImpl;
import model.Contract;

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
}
