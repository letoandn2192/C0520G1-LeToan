package model;

public class ContractDetail {
    private int contractDetailId;
    private int contractId;
    private int attachServiceId;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractId, int attachServiceId, int quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(int contractDetailId, int contractId, int attachServiceId, int quantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
