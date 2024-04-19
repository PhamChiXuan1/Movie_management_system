package sv.iuh.fit.director.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.iuh.fit.director.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
