package examportal1.examportal1.service.getuserService;


import examportal1.examportal1.repo.UserRepository;
import examportal1.examportal1.structure.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserServiceImpl implements GetUserServiceInterface {
	
	@Autowired
	private UserRepository ur;

	
	@Override
	public Optional<User> getuser(Long no) {
		return this.ur.findById(no);}
		
	}
	
		
	
	


