package dev.noukta.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    ObjectId id;
//    List<String> cast;
//    List<String> countries;
//    List<String> directors;
    List<String> genres;
//    String imdbId;
//    List<String> languages;
    String poster;
    String rated;
    Date released;
    String title;
}
