package dao.service_dao;

import model.Service;

import java.util.List;

public interface ServiceDAO {
    List<Service> findAllService();

    Service findServiceById(String id);

    void create(Service service);

    boolean editServiceInfo(Service service);

    boolean deleteService(String id);

    List<Service> search(String search);

    List<Service> getServiceByPage(int start, int offset);

    int getCountService();
}
