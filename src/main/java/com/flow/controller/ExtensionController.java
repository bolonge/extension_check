package com.flow.controller;

import com.flow.domain.Extension;
import com.flow.repository.ExtensionRepository;
import com.flow.service.ExtensionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExtensionController {
    private ExtensionService service;

    public ExtensionController(ExtensionService service) {
        this.service = service;
    }

    @GetMapping("/extension/all")
    public List<Extension> getExtensions() {
        return service.getExtensions();
    }

    @PostMapping("/extension/add")
    public Long postExtension(@RequestParam("name") String name, @RequestParam("isBlock") boolean isBlock, @RequestParam("type") int type) {
        if (service.isExistsName(name)) {
            return -1L;
        }
        if (service.isLimit()) {
            return -2L;
        }
        return service.insertExtension(name, type, isBlock);
    }

    @PostMapping("/extension/update/{id}")
    public String updateExtension(@PathVariable("id") Long id, @RequestParam("isBlock") boolean isBlock) {
        if (service.isExistsId(id)) {
            service.updateExtension(id, isBlock);
        } else {
            return "확장자가 존재하지 않습니다.";
        }
        return "";
    }

    @PostMapping("/extension/delete/{id}")
    public String deleteExtension(@PathVariable("id") Long id) {
        if (service.isExistsId(id)) {
            service.deleteExtension(id);
        } else {
            return "확장자가 존재하지 않습니다.";
        }
        return "";
    }

}
