package examportal1.examportal1.structure;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long roleId;

    //modified
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    private String roleName;

    public Role(Long roleId, Set<UserRole> userRoles, String roleName) {
        super();
        this.roleId = roleId;
        this.userRoles = userRoles;
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }



    public Role(Long roleId, String roleName) {
        super();
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
    }



}
