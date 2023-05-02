package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.repo.CategoryRepo;
import examportal1.examportal1.repo.QuestionRepo;
import examportal1.examportal1.repo.QuizRepo;
import examportal1.examportal1.structure.exam.Category;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepo  quizRepository;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public Quiz deleteQuiz(Long quizId) {
       Quiz quiz= this.quizRepository.findById(quizId).get();
        this.quizRepository.delete(quiz);
        return quiz;
    }


}
