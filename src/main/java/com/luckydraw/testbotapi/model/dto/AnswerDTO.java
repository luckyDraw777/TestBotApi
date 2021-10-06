package com.luckydraw.testbotapi.model.dto;

import lombok.Data;

@Data
public class AnswerDTO {

    private Integer id;

    private String text;

    private Integer questionId;
}
