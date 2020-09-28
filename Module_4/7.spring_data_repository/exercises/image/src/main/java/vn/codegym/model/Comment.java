package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    private int commentRate;
    private String commentAuthor;
    private String commentFeedback;
    private int commentLike;

    public Comment() {
    }

    public Comment(int commentRate, String commentAuthor, String commentFeedback, int commentLike) {
        this.commentRate = commentRate;
        this.commentAuthor = commentAuthor;
        this.commentFeedback = commentFeedback;
        this.commentLike = commentLike;
    }

    public Comment(int commentId, int commentRate, String commentAuthor, String commentFeedback, int commentLike) {
        this.commentId = commentId;
        this.commentRate = commentRate;
        this.commentAuthor = commentAuthor;
        this.commentFeedback = commentFeedback;
        this.commentLike = commentLike;
    }

    public int getId() {
        return commentId;
    }

    public void setId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(int commentRate) {
        this.commentRate = commentRate;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentFeedback() {
        return commentFeedback;
    }

    public void setCommentFeedback(String commentFeedback) {
        this.commentFeedback = commentFeedback;
    }

    public int getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(int commentLike) {
        this.commentLike = commentLike;
    }
}
