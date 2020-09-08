package bo.service_bo;

import bo.common_bo.Regex;
import dao.service_dao.ServiceDAO;
import dao.service_dao.ServiceDAOImpl;
import model.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceBOImpl implements ServiceBO{
    public static final String REGEX_ID_SERVICE = "^(DV-\\d{4})$";

    ServiceDAO serviceDAO = new ServiceDAOImpl();

    private boolean checkValidateServiceId(String id) {
        return !serviceDAO.checkServiceIdExists(id) && Regex.checkRegex(REGEX_ID_SERVICE, id) ;
    }

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

    @Override
    public List<String> checkValidateService(String id, String area, String cost, String maxPerson, String poolArea, String numberFloor) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateServiceId(id);
        boolean checkValidateArea = Regex.checkRegexDoublePositive(area);
        boolean checkValidateCost = Regex.checkRegexDoublePositive(cost);
        boolean checkValidateMaxPerson = Regex.checkRegexIntegerPositive(maxPerson);
        boolean checkValidatePoolArea = Regex.checkRegexDoublePositive(poolArea);
        boolean checkValidateFloor = Regex.checkRegexIntegerPositive(numberFloor);
        if (!(checkValidateId && checkValidateArea && checkValidateCost && checkValidateMaxPerson && checkValidatePoolArea && checkValidateFloor)) {
            if (!checkValidateId) {
                errMessList.add( "Customer ID format DV-XXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateArea) {
                errMessList.add( "Area must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateCost) {
                errMessList.add( "Cost must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateMaxPerson) {
                errMessList.add( "Person must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePoolArea) {
                errMessList.add( "Pool Area must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateFloor) {
                errMessList.add( "Floor must be positive number");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }

    @Override
    public List<String> checkValidateService(String area, String cost, String maxPerson, String poolArea, String numberFloor) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateArea = Regex.checkRegexDoublePositive(area);
        boolean checkValidateCost = Regex.checkRegexDoublePositive(cost);
        boolean checkValidateMaxPerson = Regex.checkRegexIntegerPositive(maxPerson);
        boolean checkValidatePoolArea = Regex.checkRegexDoublePositive(poolArea);
        boolean checkValidateFloor = Regex.checkRegexIntegerPositive(numberFloor);
        if (!(checkValidateArea && checkValidateCost && checkValidateMaxPerson && checkValidatePoolArea && checkValidateFloor)) {
            if (!checkValidateArea) {
                errMessList.add( "Area must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateCost) {
                errMessList.add( "Cost must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateMaxPerson) {
                errMessList.add( "Person must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePoolArea) {
                errMessList.add( "Pool Area must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateFloor) {
                errMessList.add( "Floor must be positive number");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }
}
