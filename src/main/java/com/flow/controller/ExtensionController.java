package com.flow.controller;

import com.flow.domain.Extension;
import com.flow.mapper.ExtensionMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ExtensionController {
    private ExtensionMapper mapper;

    public ExtensionController(ExtensionMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/extension/all")
    public List<Extension> getAllExtensions() {
        return mapper.findAll();
    }

    @PostMapping("/extension/add")
    public Long postExtension(@RequestParam("name") String name, @RequestParam("isBlock") boolean isBlock, @RequestParam("type") int type) {
        mapper.insertExtension(name, isBlock, type);
        return mapper.findByName(name);
    }

    @PostMapping("/extension/update/{id}")
    public void updateExtension(@PathVariable("id") Long id, @RequestParam("isBlock") boolean isBlock) {
        mapper.updateExtension(id, isBlock);
    }

    @PostMapping("/extension/delete/{id}")
    public void deleteExtension(@PathVariable("id") Long id) {
        mapper.deleteExtension(id);
    }

}
