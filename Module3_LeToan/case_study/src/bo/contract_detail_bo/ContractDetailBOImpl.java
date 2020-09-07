package bo.contract_detail_bo;

import dao.contract_detail_dao.ContractDetailDAO;
import dao.contract_detail_dao.ContractDetailDAOImpl;
import model.ContractDetail;

public class ContractDetailBOImpl implements ContractDetailBO {
    private ContractDetailDAO contractDetailDAO = new ContractDetailDAOImpl();
    @Override
    public void create(ContractDetail contractDetail) {
        contractDetailDAO.create(contractDetail);
    }
}
