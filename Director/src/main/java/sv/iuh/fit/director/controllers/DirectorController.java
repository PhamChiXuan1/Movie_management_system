package sv.iuh.fit.director.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sv.iuh.fit.director.models.Director;
import sv.iuh.fit.director.models.Movie;
import sv.iuh.fit.director.repositories.DirectorRepository;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/directors")
@AllArgsConstructor
public class DirectorController {

    private final DirectorRepository directorRepository;

    @GetMapping("/findMoviesByDirectorId/{directorId}")
    @Retry(name = "retry1")
     ResponseEntity findMovieByDirectorId(@PathVariable Long directorId) {
        RestTemplate restTemplate = new RestTemplate();
        Object list = restTemplate.getForObject("http://localhost:8082/api/movies/" + directorId.toString(), List.class);
        return ResponseEntity.ok(list);
    }



    @GetMapping("/")
    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

    @GetMapping("/{directorId}")
    public Director findDirectorById(@PathVariable("directorId") long directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }

    @PostMapping("/addDirector")
    public Director addDirector(@RequestBody Director director) {
        return directorRepository.save(director);
    }
}
