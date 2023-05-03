package examportal1.examportal1.repo;



import examportal1.examportal1.structure.exam.Question;
import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
    // Set<Question> findByQuiz(Quiz quiz);
}
