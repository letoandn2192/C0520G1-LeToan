package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    Iterable<ContractDetail> findContractDetailByContract(Contract contract);
}
