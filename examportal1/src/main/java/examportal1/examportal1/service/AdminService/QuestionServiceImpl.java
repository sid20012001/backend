package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.repo.CategoryRepo;
import examportal1.examportal1.repo.QuestionRepo;
import examportal1.examportal1.structure.exam.Question;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    public QuestionRepo questionRepo;
    @Override
    public Question addQuestion(Question question) {
        return  this.questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return  this.questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>( this.questionRepo.findAll());
    }

    @Override
    public Question getQuestion(Long id) {
        return this.questionRepo.findById(id).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
       return this.questionRepo.findByQuiz(quiz);
    }

    @Override
    public Question deleteQuestion(Long id) {
        Question question=this.questionRepo.findById(id).get();
        this.questionRepo.deleteById(id);
        return question;
    }
}
