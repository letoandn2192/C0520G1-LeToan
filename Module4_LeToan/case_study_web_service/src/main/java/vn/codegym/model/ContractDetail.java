package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.security.auth.login.Configuration;
import javax.validation.constraints.Positive;

@Entity
@Table
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractDetailId;

    @Positive
    private int contractDetailQuantity;

    @ManyToOne
    @JoinColumn(name = "contractId")
    @JsonIgnoreProperties("contractDetails")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachDetailId")
    @JsonIgnoreProperties("contractDetailGroup")
    private AttachService attachService;

    public long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(int contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
