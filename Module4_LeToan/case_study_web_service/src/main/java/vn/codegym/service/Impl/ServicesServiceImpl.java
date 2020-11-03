package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Services;
import vn.codegym.repository.ServiceRepository;
import vn.codegym.service.ServicesService;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

//    @Override
//    public Page<Services> findByIdAndName(String input, Pageable pageable) {
//        return serviceRepository.findServiceByServiceIdContainingOrServiceNameContaining(input, input, pageable);
//    }

    @Override
    public Iterable<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Services findById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public void deleteById(long id) {
        serviceRepository.deleteById(id);
    }
}
