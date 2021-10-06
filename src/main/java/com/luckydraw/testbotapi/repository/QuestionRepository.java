package com.luckydraw.testbotapi.repository;

import com.luckydraw.testbotapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select q from Question q where q.theme.id = ?1")
    List<Question> findByThemeId(Integer themeId);
}
