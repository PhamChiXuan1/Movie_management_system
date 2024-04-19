package sv.iuh.fit.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sv.iuh.fit.movie.enums.MovieType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String movieName;
    private MovieType movieType; //phim le phim bo ...
    private String uri;
    private int duration;
    private String rating;
    private String description;
    private String movieGenre;

    @ManyToOne
    private Director  director;


    public Movie(String movieName, MovieType movieType, String uri, int duration, String rating, String description, String movieGenre) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.uri = uri;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.movieGenre = movieGenre;
    }

    public Movie(String movieName, MovieType movieType, String uri, int duration, String rating, String description, String movieGenre, Director director) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.uri = uri;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.movieGenre = movieGenre;
        this.director = director;
    }
}
