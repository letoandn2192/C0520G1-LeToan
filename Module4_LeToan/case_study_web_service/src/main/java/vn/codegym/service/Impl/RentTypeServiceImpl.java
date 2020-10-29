package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.RentType;
import vn.codegym.repository.RentTypeRepository;
import vn.codegym.service.RentTypeService;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
