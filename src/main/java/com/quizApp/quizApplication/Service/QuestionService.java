package com.quizApp.quizApplication.Service;

import com.quizApp.quizApplication.DAO.QuestionDao;
import com.quizApp.quizApplication.Model.Dto.quesDto;
import com.quizApp.quizApplication.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.getMessage();;
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public String addQuestions(Question question) {
         questionDao.save(question);
         return "question Added";
    }

    public ResponseEntity<Question> findQuesById(Integer id) {
        try {
            return new ResponseEntity<>(questionDao.findById(id).orElse(null), HttpStatus.OK);
        }
        catch(Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }


    public String deleteQuesById(Integer id) {
        questionDao.deleteById(id);
        return "deleted succesfully";
    }

    public String updateAnswerById(Integer id, String newAnswer) {
        Question ques= questionDao.findById(id).orElse(null);
        if(ques!=null){
            ques.setRightAnswer(newAnswer);
            questionDao.save(ques);
            return "updated successfully!!!!!!!!";
        }
        return "not such id found";
    }

    public ResponseEntity<List<Question>> getQuesByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.getQuestionByCategory(category), HttpStatus.OK);
        }
        catch(Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}

