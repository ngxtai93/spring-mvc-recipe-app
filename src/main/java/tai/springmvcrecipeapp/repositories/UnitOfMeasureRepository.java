package tai.springmvcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.springmvcrecipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
