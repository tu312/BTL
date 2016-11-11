package uet.repository;

import uet.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tu on 10-Nov-16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
