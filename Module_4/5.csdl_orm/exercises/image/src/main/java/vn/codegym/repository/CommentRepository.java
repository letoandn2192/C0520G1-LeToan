package vn.codegym.repository;

import vn.codegym.model.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> getAllComment();

    Comment findById(int id);

    void save(Comment comment);

    void edit(Comment comment);
}
