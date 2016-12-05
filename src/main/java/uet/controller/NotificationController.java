package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import uet.DTO.NotificationDTO;
import uet.model.Notification;
import uet.service.NotificationService;

/**
 * Created by nhkha on 11/25/2016.
 */
@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    //get notification
    @RequestMapping(value="/notification/{userId}", method = RequestMethod.GET)
    public List<HashMap<String, String>> getNotification(@PathVariable("userId") int userId) {
        return (List<HashMap<String, String>>) notificationService.getNotification(userId);
    }

    //remove notification of user
    @RequestMapping(value="/notification/user/{userId}/channel/{channelId}", method = RequestMethod.POST)
    public void removeNotification(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId) {
        notificationService.removeNotification(userId, channelId);
    }
}
