package examportal1.examportal1.service.postuserService;


import examportal1.examportal1.repo.RoleRepository;
import examportal1.examportal1.repo.UserRepository;
import examportal1.examportal1.structure.User;
import examportal1.examportal1.structure.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostUserServiceImpl implements PostUserService{
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private RoleRepository rolerepository;
	

	@Override
	public User createUser(User user,Set<UserRole> userRoles) throws Exception {

		User local=this.userrepository.findByUsername(user.getUsername());
		if(local !=null) {
			System.out.println("User is Already present");
			throw new Exception("User is already present");
		}
		else {
			for(UserRole ur:userRoles) {
				rolerepository.save(ur.getRole());
			}
			
		user.getUserRoles().addAll(userRoles);
		local=this.userrepository.save(user);
		}
		return local;
	}
   
}
