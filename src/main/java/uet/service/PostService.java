package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.PostDTO;
import uet.model.Channel;
import uet.model.Post;
import uet.model.User;
import uet.model.Notification;
import uet.repository.NotificationRepository;
import uet.repository.ChannelRepository;
import uet.repository.PostRepository;
import uet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    NotificationRepository notificationRepository;

    //create post
    public Post createPost(int userId, int channelId, PostDTO postDTO){
        User user = userRepository.findOne(userId);
        int count = 0;
        Channel channel = channelRepository.findOne(channelId);
//        if (user.getStatus() == 1){
            Post post = new Post();
            post.setContent(postDTO.getContent());
            post.setUserName(user.getUserName());
            postRepository.save(post);

            channel.getPost().add(post);
            channelRepository.save(channel);
            List<User> allSubscriber = (List<User>) userRepository.findAllByChannel(channel);
            List<Notification> listNoti = (List<Notification>)  notificationRepository.findAll();
            List<Integer> noNoti = new ArrayList<>();
//            for(Notification cNotification : listNoti ){
                for ( User sUser : allSubscriber ){
                    if(userId != sUser.getId()) {
                        Notification notification = new Notification();
//
                        notification.setUserId(sUser.getId());
                        notification.setChannelId(channelId);
                        notification.setChannelName(channel.getChannelName());
                        notification.setPostContent(postDTO.getContent());
                        notification.setUserName(user.getUserName());
                        notificationRepository.save(notification);
//                        if (cNotification.getChannelId() == channelId && cNotification.getUserId() == sUser.getId()) {
//                            cNotification.setUserName(user.getUserName());
//                            notificationRepository.save(cNotification);
//                            count++;
//                        }
//                        else{
//                            noNoti.add(sUser.getId());
//                        }
                    }
                }

//            }
//            for (int suser: noNoti){
//                if(userId != suser){
//                    Notification notification = new Notification();
//
//                    notification.setUserId(suser);
//                    notification.setChannelId(channelId);
//                    notification.setChannelName(channel.getChannelName());
//                    notification.setPostContent(postDTO.getContent());
//                    notification.setUserName(user.getUserName());
//                    notificationRepository.save(notification);
//                }
//            }

//            for ( User sUser : allSubscriber ){
//                if(userId != sUser.getId()) {
//                    Notification notification = new Notification();
//                    for (Notification cNotification : listNoti ){
//                        if(cNotification.getChannelId() == channelId && cNotification.getUserId() == sUser.getId()){
//                            cNotification.setUserName(user.getUserName());
//                            notificationRepository.save(cNotification);
//                            count++;
////                            break;
//                        }
//                        else{
//                            notification.setUserId(sUser.getId());
//                            notification.setChannelId(channelId);
//                            notification.setChannelName(channel.getChannelName());
//                            notification.setPostContent(postDTO.getContent());
//                            notification.setUserName(user.getUserName());
//                            notificationRepository.save(notification);
//                        }
//                    }
////                    if(count == 0){
////                        notification.setUserId(sUser.getId());
////                        notification.setChannelId(channelId);
////                        notification.setChannelName(channel.getChannelName());
////                        notification.setPostContent(postDTO.getContent());
////                        notification.setUserName(user.getUserName());
////                        notificationRepository.save(notification);
////                    }
//                }
//            }



            return post;
//        } else {
//            throw new NullPointerException("Log in first!");
//        }
    }

    // show list post of a channel
    public List<Post> listPost(int channelId){
        Channel channel = channelRepository.findOne(channelId);
        return channel.getPost();
    }

    //show a post
    public Post showPost(int postId){
        Post post = postRepository.findOne(postId);
        return post;
    }
}
