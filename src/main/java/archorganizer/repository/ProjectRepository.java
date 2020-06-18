package archorganizer.repository;

import archorganizer.model.project.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

//    @Query("SELECT u FROM User u JOIN FETCH u.architect JOIN FETCH u.expert JOIN FETCH u.accountant JOIN FETCH u.investor WHERE u.id = :id")
//    public Optional<User> findById(@Param("id") Long id);

    @Override
    List<Project> findAll();
}
