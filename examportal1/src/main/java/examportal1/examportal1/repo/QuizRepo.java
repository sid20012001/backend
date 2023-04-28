package examportal1.examportal1.repo;

import examportal1.examportal1.structure.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
