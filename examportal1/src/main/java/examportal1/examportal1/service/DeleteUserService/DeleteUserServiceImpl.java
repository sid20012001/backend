package examportal1.examportal1.service.DeleteUserService;


import examportal1.examportal1.repo.UserRepository;
import examportal1.examportal1.structure.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserServiceImpl implements DeleteUserServiceInterface {

	@Autowired
	private UserRepository userrepository;
	
	
	
	@Override
	public User deleteUser(String username) {
		
		User user=this.userrepository.findByUsername(username);

		 this.userrepository.delete(user);
		 return user;

	}
	

}
