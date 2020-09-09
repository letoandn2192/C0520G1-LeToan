package bo.contract_detail_bo;

import model.ContractDetail;

import java.util.List;

public interface ContractDetailBO {
    void create(ContractDetail contractDetail);

    List<String> checkValidateContractDetail(String quantity);
}
