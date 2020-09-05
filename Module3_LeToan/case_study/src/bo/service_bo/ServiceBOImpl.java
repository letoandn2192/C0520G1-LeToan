package bo.service_bo;

import dao.service_dao.ServiceDAO;
import dao.service_dao.ServiceDAOImpl;
import model.Service;

import java.util.List;

public class ServiceBOImpl implements ServiceBO{
    ServiceDAO serviceDAO = new ServiceDAOImpl();

    @Override
    public List<Service> findAllService() {
        return serviceDAO.findAllService();
    }

    @Override
    public Service findServiceById(String id) {
        return serviceDAO.findServiceById(id);
    }

    @Override
    public void create(Service service) {
        serviceDAO.create(service);
    }

    @Override
    public boolean editServiceInfo(Service service) {
        return serviceDAO.editServiceInfo(service);
    }

    @Override
    public boolean deleteService(String id) {
        return serviceDAO.deleteService(id);
    }

    @Override
    public List<Service> search(String search) {
        return serviceDAO.search(search);
    }

    @Override
    public List<Service> getServiceByPage(int start, int offset) {
        return serviceDAO.getServiceByPage(start, offset);
    }

    @Override
    public int getCountService() {
        return serviceDAO.getCountService();
    }
}
