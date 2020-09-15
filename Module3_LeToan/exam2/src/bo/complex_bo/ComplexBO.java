package bo.complex_bo;

import model.Complex;

import java.util.List;

public interface ComplexBO {
    List<Complex> findAllComplex();

    Complex findComplexById(String id);

//    boolean editProductInfo(Complex product);

    boolean deleteComplex(String id);

    void create(Complex complex);

    List<Complex> search(String search);

    boolean checkComplexIdExists(String id);

    List<String> checkValidateComplex(String id, String area, String floor, String cost, String startDate, String endDate);
}
