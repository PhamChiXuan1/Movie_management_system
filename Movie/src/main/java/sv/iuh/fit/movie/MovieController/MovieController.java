package sv.iuh.fit.movie.MovieController;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.iuh.fit.movie.Repositories.MovieRepository;
import sv.iuh.fit.movie.models.Movie;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{directorId}")
    @Retry(name = "retry1")
    List<Movie> getMovieByDirectorId(@PathVariable Long directorId) {
        return movieRepository.getAllByDirectorId(directorId);

    }

    @PostMapping("/createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
