package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Comment;
import vn.codegym.repository.CommentRepository;
import vn.codegym.repository.CommentRepositoryImpl;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
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
