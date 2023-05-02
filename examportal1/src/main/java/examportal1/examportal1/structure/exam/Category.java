package examportal1.examportal1.structure.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cid;

    @Column(length = 2000)
    private String title;

    @Column(length = 2000)
    private String description;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL,mappedBy = "category")
    @JsonIgnore
    Set<Quiz> quiz=new LinkedHashSet<>();

    public Category() {
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(Set<Quiz> quiz) {
        this.quiz = quiz;
    }

    public Category(Long cid, String title, String description, Set<Quiz> quiz) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.quiz = quiz;
    }
}
