package dev.noukta.movies.controller;

import dev.noukta.movies.model.Comment;
import dev.noukta.movies.service.CommentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // Create a new comment
//    @PostMapping
//    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
//        Comment createdComment = commentService.createComment(comment);
//        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
//    }

    // Get comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comment>> getCommentById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    // Get comments by movie ID
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Comment>> getCommentsByMovieId(@PathVariable ObjectId movieId) {
        List<Comment> comments = commentService.getCommentsByMovieId(movieId);
        return ResponseEntity.ok(comments);
    }

    // Update a comment
//    @PutMapping("/{id}")
//    public ResponseEntity<Comment> updateComment(
//            @PathVariable String id,
//            @RequestBody Comment comment
//    ) {
//        Comment updatedComment = commentService.updateComment(id, comment);
//        return ResponseEntity.ok(updatedComment);
//    }

    // Delete a comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable ObjectId id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}