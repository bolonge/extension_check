package com.flow.service;

import com.flow.domain.Extension;
import com.flow.repository.ExtensionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtensionService {

    private ExtensionRepository repository;

    public ExtensionService(ExtensionRepository repository) {
        this.repository = repository;
    }

    public List<Extension> getExtensions() {
        return repository.findAll();
    }

    public Long insertExtension(String name, int type, boolean isBlock) {
        repository.insertExtension(name, isBlock, type);
        return repository.findIdByName(name);
    }

    public void updateExtension(Long id, boolean isBlock) {
        repository.updateExtension(id, isBlock);
    }

    public void deleteExtension(Long id) {
        repository.deleteExtension(id);
    }

    public boolean isLimit() {
        return repository.findByCustomer().size() >= 200;
    }

    public boolean isExistsId(Long id) {
        return repository.findById(id) != null;
    }

    public boolean isExistsName(String name) {
        return repository.findIdByName(name) != null;
    }


}
