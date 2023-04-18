package examportal1.examportal1.repo;


import examportal1.examportal1.structure.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);

}
