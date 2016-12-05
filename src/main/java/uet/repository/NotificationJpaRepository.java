package uet.repository;

import org.springframework.data.repository.Repository;
import uet.model.Notification;

import java.util.List;

/**
 * Created by nhkha on 11/25/2016.
 */
@org.springframework.stereotype.Repository
    public interface NotificationJpaRepository extends Repository<Notification, Integer>{
        Notification findByUserIdAndChannelId(Integer userId, Integer channelId);
    }

