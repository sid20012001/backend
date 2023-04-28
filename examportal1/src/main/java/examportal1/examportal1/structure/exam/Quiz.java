package examportal1.examportal1.structure.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long qid;

    boolean active;

    String title;

    String description;

    long maxMark;

    long numberOfQuestion;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Category category;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Question> question=new HashSet<Question>();

    public Quiz() {
    }

    public Quiz(Long qid, boolean active, String title, String description, long maxMark, long numberOfQuestion, Category category, Set<Question> question) {
        this.qid = qid;
        this.active = active;
        this.title = title;
        this.description = description;
        this.maxMark = maxMark;
        this.numberOfQuestion = numberOfQuestion;
        this.category = category;
        this.question = question;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public long getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(long maxMark) {
        this.maxMark = maxMark;
    }

    public long getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(long numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestion() {
        return question;
    }

    public void setQuestion(Set<Question> question) {
        this.question = question;
    }
}
