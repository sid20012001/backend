package examportal1.examportal1.controller;

import examportal1.examportal1.service.AdminService.QuestionService;
import examportal1.examportal1.service.AdminService.QuizService;
import examportal1.examportal1.structure.exam.Question;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;


    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {

        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    @GetMapping("/{qid}")
    public Question get(@PathVariable("quesId") Long quesId) {
        return this.service.getQuestion(quesId);
    }

    @GetMapping("/")
    public Set<Question> getQuestion (){
       return this.service.getQuestions();
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId) {
        this.service.deleteQuestion(quesId);
    }

    @GetMapping("/quiz")
    public Set<Question> getQuestionOfQuiz(@RequestBody Quiz quiz){
       return this.service.getQuestionsOfQuiz(quiz);
    }

}
