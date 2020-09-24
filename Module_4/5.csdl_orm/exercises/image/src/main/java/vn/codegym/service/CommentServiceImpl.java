package vn.codegym.service;

import vn.codegym.model.Comment;
import vn.codegym.repository.CommentRepository;
import vn.codegym.repository.CommentRepositoryImpl;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository = new CommentRepositoryImpl();
    @Override
    public List<Comment> getAllComment() {
        return commentRepository.getAllComment();
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void edit(Comment comment) {
        commentRepository.edit(comment);
    }
}
