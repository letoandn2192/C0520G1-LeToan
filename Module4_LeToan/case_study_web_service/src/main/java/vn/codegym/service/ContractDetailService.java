package vn.codegym.service;

import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;

public interface ContractDetailService {
    Iterable<ContractDetail> findAll();

    ContractDetail findById(long id);

    void save(ContractDetail contractDetail);

    void deleteById(long id);

    Iterable<ContractDetail> findContractDetailByContract(Contract contract);
}
