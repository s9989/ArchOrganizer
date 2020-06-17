package archorganizer.repository;

import archorganizer.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

//    @Query("SELECT u FROM User u JOIN FETCH u.architect JOIN FETCH u.expert JOIN FETCH u.accountant JOIN FETCH u.investor WHERE u.id = :id")
//    public Optional<User> findById(@Param("id") Long id);

    @Override
    List<User> findAll();
}
