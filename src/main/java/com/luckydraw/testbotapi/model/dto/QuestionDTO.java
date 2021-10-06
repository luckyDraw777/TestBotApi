package com.luckydraw.testbotapi.model.dto;

import lombok.Data;

@Data
public class QuestionDTO {

    private Integer id;

    private String text;

    private Integer rightAnswerId;
}
