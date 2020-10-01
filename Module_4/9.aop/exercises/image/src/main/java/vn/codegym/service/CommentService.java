package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    Page<Comment> getAllComment(Pageable pageable);

    Comment findById(int id);

    void save(Comment comment);
}
