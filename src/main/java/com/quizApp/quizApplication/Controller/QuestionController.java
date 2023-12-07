package com.quizApp.quizApplication.Controller;

import com.quizApp.quizApplication.Model.Dto.quesDto;
import com.quizApp.quizApplication.Model.Question;
import com.quizApp.quizApplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @PostMapping("add/question")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestions(question);
    }
    @GetMapping("question/id/{id}")
    public ResponseEntity<Question> findQuesById(@PathVariable Integer id){
        return questionService.findQuesById(id);
    }
    @DeleteMapping("delete/question/id/{id}")
    public String deleteQuestionById(@PathVariable Integer id){
        return questionService.deleteQuesById(id);
    }
    @PutMapping("update/answer/id/{id}")
    public String updateAnswerById(@PathVariable Integer id,@RequestParam String newAnswer){
        return questionService.updateAnswerById(id,newAnswer);
    }
    @GetMapping("fetch/question/category/{category}")
    public ResponseEntity<List<Question>> getQuesByCategory(@PathVariable String category){
        return questionService.getQuesByCategory(category);
    }

}
