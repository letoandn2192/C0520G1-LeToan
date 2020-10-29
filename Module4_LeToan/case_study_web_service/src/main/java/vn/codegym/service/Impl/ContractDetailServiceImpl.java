package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.ContractDetailRepository;
import vn.codegym.service.ContractDetailService;
@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteById(long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public Iterable<ContractDetail> findContractDetailByContract(Contract contract) {
        return contractDetailRepository.findContractDetailByContract(contract);
    }
}
