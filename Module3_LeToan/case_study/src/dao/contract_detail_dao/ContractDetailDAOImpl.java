package dao.contract_detail_dao;

import dao.DBConnection;
import model.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailDAOImpl implements ContractDetailDAO {
    private static final String CREATE_NEW_CONTRACT_DETAIL = "INSERT INTO contract_detail (contract_id, attach_service_id, quantity) " +
            "VALUES (?, ?, ?);";

    @Override
    public void create(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_CONTRACT_DETAIL);
                preparedStatement.setInt(1, contractDetail.getContractId());
                preparedStatement.setInt(2, contractDetail.getAttachServiceId());
                preparedStatement.setInt(3, contractDetail.getQuantity());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }
}
