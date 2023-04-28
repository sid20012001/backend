package examportal1.examportal1.service.AdminService;

import examportal1.examportal1.structure.exam.Category;
import examportal1.examportal1.structure.exam.Question;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface QuestionService {

    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long id);

    public Set<Question>getQuestionsOfQuiz(Quiz quiz);
    public Question deleteQuestion(Long id);

}
