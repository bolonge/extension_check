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
        if (mapper.findIdByName(name) > 0) {
            return -1L;
        }
        mapper.insertExtension(name, isBlock, type);
        return mapper.findIdByName(name);
    }

    @PostMapping("/extension/update/{id}")
    public String updateExtension(@PathVariable("id") Long id, @RequestParam("isBlock") boolean isBlock) {
        if (mapper.findById(id) > 0) {
            mapper.updateExtension(id, isBlock);
        } else {
            return "확장자가 존재하지 않습니다.";
        }
        return "";
    }

    @PostMapping("/extension/delete/{id}")
    public String deleteExtension(@PathVariable("id") Long id) {
        if (mapper.findById(id) > 0) {
            mapper.deleteExtension(id);
        } else {
            return "확장자가 존재하지 않습니다.";
        }
        return "";
    }

}
