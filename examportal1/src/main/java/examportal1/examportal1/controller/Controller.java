package examportal1.examportal1.controller;


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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping("/user")
    public User postUser(@RequestBody User user ) throws Exception {
        Role role=new Role();
        role.setRoleId(2L);
        role.setRoleName("Normal");
        UserRole urr=new UserRole();
        urr.setUser(user);
        urr.setRole(role);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        HashSet<UserRole> set1=new HashSet<UserRole>();
        set1.add(urr);
        return this.postUserService.createUser(user, set1);
    }

    @CrossOrigin("*")
    @GetMapping("/{no}")
    public Optional<User> getUser(@PathVariable("no")Long no){
        return getUserService.getuser(no);
    }


    @CrossOrigin("*")
    @PutMapping("/{name}")
    public User updateUser(@RequestBody User user,@PathVariable ("name")String name) throws Exception {
        return this.putUserService.updateuser(name, user);
    }


    @CrossOrigin("*")
    @DeleteMapping("/{username}")
    public User deleteUser(@PathVariable("username")String username) {

        return  this.deleteUserService.deleteUser(username);

    }

    @CrossOrigin("*")
    @PostMapping("/generate-token")
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


    @GetMapping("/current-user")
    public UserDetails getCurrentUser(Principal principal)
    {
        return this.customUserDetailsService.loadUserByUsername(principal.getName());
    }




    }





