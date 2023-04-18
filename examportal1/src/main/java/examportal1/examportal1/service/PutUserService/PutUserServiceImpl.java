package examportal1.examportal1.service.PutUserService;


import examportal1.examportal1.repo.UserRepository;
import examportal1.examportal1.structure.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutUserServiceImpl implements PutUserServiceInterface {

	@Autowired
	private UserRepository ur;


	@Override
	public User updateuser(String name, User user) throws Exception {
		User user1 = this.ur.findByUsername(name);
		if(user1==null){
			throw new Exception("user not present");
		}
		else {
			this.ur.delete(user1);
			this.ur.save(user);

		}
		return user;


	}

}
