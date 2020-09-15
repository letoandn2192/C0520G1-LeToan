package dao.complex_dao;

import model.Complex;

import java.util.List;

public interface ComplexDAO {
    List<Complex> findAllComplex();

    Complex findComplexById(String id);

    boolean deleteComplex(String id);

    void create(Complex complex);

    List<Complex> search(String search);

    boolean checkComplexIdExists(String id);
}
