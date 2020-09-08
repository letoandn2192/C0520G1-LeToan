package bo.contract_bo;

import model.Contract;

import java.util.List;

public interface ContractBO {
    List<Contract> findAllContract();

    Contract findContractById(int id);

    void create(Contract contract);

    boolean editContractInfo(Contract contract);

    boolean deleteContract(int id);

    List<Contract> search(String search);

    List<Contract> getContractByPage(int start, int offset);

    int getCountContract();

    List<Contract> managerContract();

    List<String> checkValidateContract(String area, String cost);
}
