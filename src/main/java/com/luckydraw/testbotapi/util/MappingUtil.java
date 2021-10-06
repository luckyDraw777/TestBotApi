package com.luckydraw.testbotapi.util;

import com.luckydraw.testbotapi.model.Answer;
import com.luckydraw.testbotapi.model.Question;
import com.luckydraw.testbotapi.model.Theme;
import com.luckydraw.testbotapi.model.dto.AnswerDTO;
import com.luckydraw.testbotapi.model.dto.QuestionDTO;
import com.luckydraw.testbotapi.model.dto.ThemeDTO;
import org.springframework.stereotype.Service;

@Service
public class MappingUtil {

    public ThemeDTO convertThemeToDTO(Theme theme){
        ThemeDTO themeDTO = new ThemeDTO();

        themeDTO.setId(theme.getId());
        themeDTO.setName(theme.getName());

        return themeDTO;
    }

    public QuestionDTO convertQuestionToDTO(Question question){
        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId(question.getId());
        questionDTO.setText(question.getText());
        questionDTO.setRightAnswerId(question.getRightAnswer().getId());

        return questionDTO;
    }

    public AnswerDTO convertAnswerToDTO(Answer answer){
        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setId(answer.getId());
        answerDTO.setText(answer.getText());
        answerDTO.setQuestionId(answer.getQuestion().getId());

        return answerDTO;
    }
}
