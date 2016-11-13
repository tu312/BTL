package uet.repository;

import uet.model.Channel;
import uet.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tu on 10-Nov-16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
    List<User> findByChannel(Integer channelId);
}
