package com.luckydraw.testbotapi.service;

import com.luckydraw.testbotapi.model.Theme;
import com.luckydraw.testbotapi.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThemeService {

    private ThemeRepository repository;

    @Autowired
    public ThemeService(ThemeRepository repository) {
        this.repository = repository;
    }

    public List<Theme> getAll(){
        return repository.findAll();
    }
}
