package sv.iuh.fit.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sv.iuh.fit.movie.Repositories.DirectorRepository;
import sv.iuh.fit.movie.Repositories.MovieRepository;
import sv.iuh.fit.movie.enums.MovieType;
import sv.iuh.fit.movie.models.Director;
import sv.iuh.fit.movie.models.Movie;

import java.util.Random;

@SpringBootApplication
public class MovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Autowired
    private MovieRepository movieRepository;
    @Autowired

    private DirectorRepository directorRepository;

//    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                Movie movie = new Movie("movie name" + i, MovieType.PHIM_BO, "lms.iuh" + i, random.nextInt(), "rating" + i, "desc" + i, "gerne" + i
                        , new Director(1));
                movieRepository.save(movie);
            }
        };
    }
}
