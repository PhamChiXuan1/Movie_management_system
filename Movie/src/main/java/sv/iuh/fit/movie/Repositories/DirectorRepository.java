package sv.iuh.fit.movie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.iuh.fit.movie.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
