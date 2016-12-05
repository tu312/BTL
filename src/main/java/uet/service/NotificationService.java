package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.model.Notification;
import uet.repository.NotificationJpaRepository;
import uet.repository.NotificationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nhkha on 11/25/2016.
 */
@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationJpaRepository notificationJpaRepository;
    public List<HashMap<String, String>> getNotification(int userId) {

        List<HashMap<String, String>> listNotification = new ArrayList<>();
        List<Notification> listNoti = (List<Notification>)  notificationRepository.findAll();
        for (Notification notification : listNoti ){
            if(notification.getUserId() == userId) {
                HashMap<String, String> lNoti = new HashMap<>();
                String channelName = notification.getChannelName();
                String channelId = String.valueOf(notification.getChannelId());
                String userName = notification.getUserName();
                String UserId = String.valueOf(notification.getUserId());
                String postContent = notification.getPostContent();
                lNoti.put("channelName", channelName);
                lNoti.put("channelId", channelId);
                lNoti.put("postUser", userName);
                lNoti.put("UserId", UserId);
                lNoti.put("postContent", postContent);
                listNotification.add(lNoti);
            }
        }
        return listNotification;
    }



    public void removeNotification(int userId, int channelId) {
//        List<HashMap<String, String>> listNotification = new ArrayList<>();
        Notification notification = notificationJpaRepository.findByUserIdAndChannelId(userId, channelId);
        notificationRepository.delete(notification);
//        List<Notification> listNoti = (List<Notification>)  notificationRepository.findAll();
//        for (Notification notification : listNoti ){
//            if(notification.getUserId() == userId && notification.getChannelId() == channelId) {
//                notificationRepository.delete(notification);
//            }
//        }
    }
}
