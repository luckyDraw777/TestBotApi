package com.luckydraw.testbotapi.controller;

import com.luckydraw.testbotapi.model.Theme;
import com.luckydraw.testbotapi.model.dto.ThemeDTO;
import com.luckydraw.testbotapi.service.ThemeService;
import com.luckydraw.testbotapi.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThemeController {

    private ThemeService service;

    private MappingUtil mappingUtil;

    @Autowired
    public ThemeController(ThemeService service, MappingUtil mappingUtil) {
        this.service = service;
        this.mappingUtil = mappingUtil;
    }

    @GetMapping("/api/themes")
    public List<ThemeDTO> getAll(){

        List<ThemeDTO> themes = new ArrayList<>();

        for(Theme theme : service.getAll()){
            themes.add(mappingUtil.convertThemeToDTO(theme));
        }

        return themes;
    }
}
