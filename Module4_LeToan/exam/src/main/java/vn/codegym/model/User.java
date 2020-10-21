package vn.codegym.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;

    @OneToMany(mappedBy = "user")
    private Collection<Question> questionList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(Collection<Question> questionList) {
        this.questionList = questionList;
    }
}
