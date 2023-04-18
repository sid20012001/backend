package examportal1.examportal1.structure;
import jakarta.persistence.*;
@Entity

public class UserRole {

    public UserRole() {
        super();
    }

    public UserRole(long userRoleId, User user, Role role) {
        super();
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne()
    private Role role;
}
