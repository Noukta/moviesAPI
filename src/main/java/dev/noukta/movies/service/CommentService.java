package dev.noukta.movies.service;

import dev.noukta.movies.model.Comment;
import dev.noukta.movies.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // Create
//    public Comment createComment(Comment comment) {
//        comment.setDate(new Date()); // Automatically set current date
//        return commentRepository.save(comment);
//    }

    public Optional<Comment> getCommentById(ObjectId id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getCommentsByMovieId(ObjectId movieId) {
        return commentRepository.findByMovieId(movieId);
    }

    public List<Comment> getCommentsByEmail(String email) {
        return commentRepository.findByEmail(email);
    }

//    // Update
//    public Comment updateComment(String id, Comment updatedComment) {
//        return commentRepository.findById(id)
//                .map(existingComment -> {
//                    existingComment.setName(updatedComment.getName());
//                    existingComment.setEmail(updatedComment.getEmail());
//                    existingComment.setText(updatedComment.getText());
//                    return commentRepository.save(existingComment);
//                })
//                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
//    }

    // Delete
    public void deleteComment(ObjectId id) {
        commentRepository.deleteById(id);
    }


    // Additional query methods
    public List<Comment> getCommentsAfterDate(Date date) {
        return commentRepository.findByDateAfter(date);
    }
}