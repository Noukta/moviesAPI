package dev.noukta.movies.repository;

import dev.noukta.movies.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
    // Find comments by movie ID
    List<Comment> findByMovieId(ObjectId movieId);

    // Find comments by email
    List<Comment> findByEmail(String email);

    // Find comments by name
    List<Comment> findByName(String name);

    // Find comments after a specific date
    List<Comment> findByDateAfter(Date date);
}