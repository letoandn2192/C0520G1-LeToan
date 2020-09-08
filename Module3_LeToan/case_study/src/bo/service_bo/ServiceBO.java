package bo.service_bo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAllService();

    Service findServiceById(String id);

    void create(Service service);

    boolean editServiceInfo(Service service);

    boolean deleteService(String id);

    List<Service> search(String search);

    List<Service> getServiceByPage(int start, int offset);

    int getCountService();

    List<String> checkValidateService(String id, String area, String cost, String maxPerson, String poolArea, String numberFloor);

    List<String> checkValidateService(String area, String cost, String maxPerson, String poolArea, String numberFloor);
}
