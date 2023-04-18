package examportal1.examportal1;


import examportal1.examportal1.Utility.JwtUtil;
import examportal1.examportal1.service.CustomUserDetailsService;
import examportal1.examportal1.service.DeleteUserService.DeleteUserServiceImpl;
import examportal1.examportal1.service.PutUserService.PutUserServiceImpl;
import examportal1.examportal1.service.getuserService.GetUserServiceImpl;
import examportal1.examportal1.service.postuserService.PostUserService;
import examportal1.examportal1.structure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private PostUserService postUserService;

    @Autowired
    private GetUserServiceImpl getUserService;

    @Autowired
    private PutUserServiceImpl putUserService;

    @Autowired
    private DeleteUserServiceImpl deleteUserService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;



    @PostMapping("/user")
    public User postUser(@RequestBody User user ) throws Exception {
        Role role=new Role();
        role.setRoleId(1L);
        role.setRoleName("Normal");
        UserRole urr=new UserRole();
        urr.setUser(user);
        urr.setRole(role);
        HashSet<UserRole> set1=new HashSet<UserRole>();
        set1.add(urr);
        return this.postUserService.createUser(user, set1);
    }

    @GetMapping("/{no}")
    public Optional<User> getUser(@PathVariable("no")Long no){
        return getUserService.getuser(no);
    }


    @PutMapping("/{name}")
    public User updateUser(@RequestBody User user,@PathVariable ("name")String name) throws Exception {
        return this.putUserService.updateuser(name, user);
    }


    @DeleteMapping("/{username}")
    public User deleteUser(@PathVariable("username")String username) {

        return  this.deleteUserService.deleteUser(username);

    }

    @PostMapping("/authenticate")
    public ResponseToken authenticate(@RequestBody RequestCredentical requestCredentical){
        //here is the code authntication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestCredentical.getUsername(), requestCredentical.getPassword()));

        // Set the authenticated user in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (authentication.isAuthenticated()) {
            // Generate a JWT token
            UserDetails userDetails = userDetailsService.loadUserByUsername(requestCredentical.getUsername());
            String jwtToken = jwtUtil.generateToken(userDetails);
            return new ResponseToken(jwtToken);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }



    }





