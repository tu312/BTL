package uet.repository;

import uet.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nhkha on 12/3/2016.
 */
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer>{
    Notification findByUserId(Integer userId);
}
