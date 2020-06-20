package archorganizer.repository;

import archorganizer.model.relations.Implementation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImplementationRepository extends CrudRepository<Implementation, Long> {

    @Override
    List<Implementation> findAll();
}
