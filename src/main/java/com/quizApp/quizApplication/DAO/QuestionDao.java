package com.quizApp.quizApplication.DAO;

import com.quizApp.quizApplication.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> getQuestionByCategory(String category);
}
