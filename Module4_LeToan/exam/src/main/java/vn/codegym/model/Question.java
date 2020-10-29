package vn.codegym.model;

import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    @NotEmpty(message = "Not Empty!!!")
    @Size(min = 5, max = 100, message = "Length default from 5 to 100!!!")
    private String questionTitle;
    @NotEmpty(message = "Not Empty!!!")
    @Size(min = 10, max = 100, message = "Length default from 10 to 100!!!")
    private String questionQuestion;
    private String questionAnswer;
    private LocalDate questionDateCreate;
    private String questionStatus;

    @ManyToOne
    @JoinColumn(name = "questionTypeId")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "UserId")
//    private User feedBacker = null;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionQuestion() {
        return questionQuestion;
    }

    public void setQuestionQuestion(String questionQuestion) {
        this.questionQuestion = questionQuestion;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public LocalDate getQuestionDateCreate() {
        return questionDateCreate;
    }

    public void setQuestionDateCreate(LocalDate questionDateCreate) {
        this.questionDateCreate = questionDateCreate;
    }

    public String getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(String questionStatus) {
        this.questionStatus = questionStatus;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
