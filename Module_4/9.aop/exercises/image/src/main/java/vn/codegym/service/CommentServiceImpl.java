package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.exception.BadWordException;
import vn.codegym.model.BadWord;
import vn.codegym.model.Comment;
import vn.codegym.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Page<Comment> getAllComment(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        List<String> badWordList = BadWord.getBadWordList();
        for (String word: badWordList) {
            if (comment.getCommentFeedback().toLowerCase().contains(word)) {
                throw new BadWordException();
            }
        }
        commentRepository.save(comment);
    }
}
