package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.exception.BadWordException;
import vn.codegym.model.BadWord;
import vn.codegym.model.Comment;
import vn.codegym.service.CommentService;

import java.util.List;

@Controller
public class ImageController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public String showHomePage(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.getAllComment(pageable));
        return "views/display";
    }

    @PostMapping("/comment")
    public String comment(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("{id}/{likes}/edit")
    public String edit(@PathVariable("id") int id, @PathVariable("likes") int likes) {
        Comment comment = commentService.findById(id);
        comment.setCommentLike(likes);
        commentService.save(comment);
        return "redirect:/";
    }
}
