package com.luckydraw.testbotapi.controller;

import com.luckydraw.testbotapi.model.Question;
import com.luckydraw.testbotapi.model.dto.QuestionDTO;
import com.luckydraw.testbotapi.service.QuestionService;
import com.luckydraw.testbotapi.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private MappingUtil mappingUtil;

    @GetMapping("/api/questions")
    public List<QuestionDTO> getAll(){
        return convertList(service.getAll());
    }

    @GetMapping("/api/questions/theme/{themeId}")
    public List<QuestionDTO> getQuestionsByTheme(@PathVariable(value = "themeId") Integer themeId){
        return convertList(service.getByThemeId(themeId));
    }

    private List<QuestionDTO> convertList(List<Question> questions){
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for(Question question : questions) {
            questionDTOS.add(mappingUtil.convertQuestionToDTO(question));
        }

        return questionDTOS;
    }
}
