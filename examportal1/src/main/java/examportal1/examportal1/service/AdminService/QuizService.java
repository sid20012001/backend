package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.structure.exam.Category;
import examportal1.examportal1.structure.exam.Question;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizes();
    public Quiz getQuiz(Long id);
    public Quiz deleteQuiz(Long id);

}
