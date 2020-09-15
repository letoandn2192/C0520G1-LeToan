package bo.complex_bo;

import bo.common_bo.Regex;
import dao.complex_dao.ComplexDAO;
import dao.complex_dao.ComplexDAOImpl;
import model.Complex;

import java.util.ArrayList;
import java.util.List;

public class ComplexBOImpl implements ComplexBO {
    public static final String REGEX_ID_COMPLEX = "^[0-9A-Z]{3}[-][0-9A-Z]{2}[-][0-9A-Z]{2}$";
    private ComplexDAO complexDAO = new ComplexDAOImpl();

    private boolean checkValidateComplexId(String id) {
        return !complexDAO.checkComplexIdExists(id) && Regex.checkRegex(REGEX_ID_COMPLEX, id) ;
    }

    @Override
    public List<Complex> findAllComplex() {
        return complexDAO.findAllComplex();
    }

    @Override
    public Complex findComplexById(String id) {
        return complexDAO.findComplexById(id);
    }

    @Override
    public boolean deleteComplex(String id) {
        return complexDAO.deleteComplex(id);
    }

    @Override
    public void create(Complex complex) {
        complexDAO.create(complex);
    }

    @Override
    public List<Complex> search(String search) {
        return complexDAO.search(search);
    }

    @Override
    public boolean checkComplexIdExists(String id) {
        return complexDAO.checkComplexIdExists(id);
    }

    @Override
    public List<String> checkValidateComplex(String id, String area, String floor, String cost, String startDate, String endDate) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateComplexId(id);
        boolean checkValidateArea = Regex.checkRegexArea(area);
        boolean checkValidateFloor = Regex.checkRegexFloor(floor);
        boolean checkValidateCost = Regex.checkRegexIdNumber(cost);
        boolean checkValidateStartDate = Regex.checkValidateDate(startDate);
        boolean checkValidateEndDate = Regex.checkValidateDate(endDate);
        if (!(checkValidateId && checkValidateArea && checkValidateFloor && checkValidateCost && checkValidateStartDate && checkValidateEndDate)) {
            if (!checkValidateId) {
                errMessList.add( "Customer ID format XXX-XX-XX (X from 0-9 A-Z)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateArea) {
                errMessList.add( "Area must be positive number and > 20");
            } else {
                errMessList.add("");
            }
            if (!checkValidateFloor) {
                errMessList.add( "Maximum floor is 15");
            } else {
                errMessList.add("");
            }
            if (!checkValidateCost) {
                errMessList.add( "Cost at least 1000000");
            } else {
                errMessList.add("");
            }
            if (!checkValidateStartDate) {
                errMessList.add( "Format date DD/MM/YYYY");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEndDate) {
                errMessList.add( "Format date DD/MM/YYYY");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }
}
