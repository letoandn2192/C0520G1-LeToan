package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.AttachService;
import vn.codegym.repository.AttachServiceRepository;
import vn.codegym.service.AttachServiceService;
@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
