package com.luckydraw.testbotapi.controller;

import com.luckydraw.testbotapi.model.Answer;
import com.luckydraw.testbotapi.model.dto.AnswerDTO;
import com.luckydraw.testbotapi.service.AnswerService;
import com.luckydraw.testbotapi.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService service;

    @Autowired
    private MappingUtil mappingUtil;

    @GetMapping("/api/answers")
    public List<AnswerDTO> getAll(){
        return convertList(service.getAll());
    }

    @GetMapping("/api/answers/question/{questionId}")
    public List<AnswerDTO> getByQuestionId(@PathVariable(value = "questionId") Integer questionId){
        return convertList(service.getByQuestionId(questionId));
    }

    @GetMapping("/api/answer/{id}")
    public AnswerDTO getById(@PathVariable(value = "id") Integer id){
        return mappingUtil.convertAnswerToDTO(service.getById(id));
    }

    private List<AnswerDTO> convertList(List<Answer> answers){
        List<AnswerDTO> answerDTOS = new ArrayList<>();

        for(Answer answer : answers){
            answerDTOS.add(mappingUtil.convertAnswerToDTO(answer));
        }

        return answerDTOS;
    }
}
