package dao.contract_dao;

import model.Contract;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAllContract();

    Contract findContractById(int id);

    void create(Contract contract);

    boolean editContractInfo(Contract contract);

    boolean deleteContract(int id);

    List<Contract> search(String search);

    List<Contract> getContractByPage(int start, int offset);

    int getCountContract();

    List<Contract> managerContract();
}
