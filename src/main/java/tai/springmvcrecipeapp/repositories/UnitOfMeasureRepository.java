package tai.springmvcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.springmvcrecipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
