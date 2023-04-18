package examportal1.examportal1.service.postuserService;

import examportal1.examportal1.structure.User;
import examportal1.examportal1.structure.UserRole;

import java.util.Set;

//
public interface PostUserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception ;

}
