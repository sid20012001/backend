package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.repo.CategoryRepo;
import examportal1.examportal1.repo.QuizRepo;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    public QuizRepo quizRepo;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public Quiz getQuiz(Long id) {
        return this.quizRepo.findById(id).get();
    }

    @Override
    public Quiz deleteQuiz(Long id) {
        Quiz quiz=this.quizRepo.findById(id).get();
        this.quizRepo.deleteById(id);
        return quiz ;
    }
}
