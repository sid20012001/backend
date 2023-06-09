package examportal1.examportal1.structure;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails {

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority>set=new HashSet<Authority>();
        this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRoleName()));
        });
        return set;
    }
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    //this


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled=true;
    private String profile;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public User(long id, String username, String password, String firstname, String lastname, String email,
                String phone, boolean enabled, String profile, Set<UserRole> userRoles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile = profile;
        this.userRoles = userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User(long id, String username, String password, String firstname, String lastname, String email,
                String phone, boolean enabled,String profile) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile=profile;
    }
    public User() {
        super();
    }


//    @Override
//    public String toString() {
//        return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
//                + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", enabled=" + enabled
//                + ", profile=" + profile + "]";
//    }









}
