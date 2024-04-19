package sv.iuh.fit.director.models;

import jakarta.persistence.*;
import lombok.*;
import sv.iuh.fit.director.enums.MovieType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
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
    private Director director;


    public Movie(String movieName, MovieType movieType, String uri, int duration, String rating, String description, String movieGenre) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.uri = uri;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.movieGenre = movieGenre;
    }
}
