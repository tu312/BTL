package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.UserDTO;
import uet.model.Channel;
import uet.model.User;
import uet.repository.ChannelRepository;
import uet.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;

    //sign up
    public User signup(UserDTO userDTO){
        User user1  = userRepository.findByUserName(userDTO.getUserName());
        if (user1 == null){
            if(userDTO.getUserName() != null && userDTO.getPassword() != null){
                User user = new User();
                user.setUserName(userDTO.getUserName());
                user.setPassword(userDTO.getPassword());
                user.setStatus(0);
                return userRepository.save(user);
            } else {
                throw new NullPointerException("Missing information.");
            }
        } else {
            throw new NullPointerException("User existed.");
        }
    }

    //log in
    public User login(UserDTO userDTO){
        User user = userRepository.findByUserName(userDTO.getUserName());
        if (userDTO.getPassword().equals(user.getPassword())){
            user.setStatus(1);
            return userRepository.save(user);
        } else {
            throw new NullPointerException("Wrong password.");
        }
    }

    //log out
    public User logout(UserDTO userDTO){
        User user = userRepository.findByUserName(userDTO.getUserName());
        user.setStatus(0);
        return userRepository.save(user);
    }

    //show list subscribers of channel
    public List<String> showSubscriber(int channelId){
        Channel channel = channelRepository.findById(channelId);
        List<User> allSubscriber = (List<User>) userRepository.findAllByChannel(channel);
        ArrayList<String> allSubscriberName = new ArrayList<String>();
        for ( User user : allSubscriber ){
            String name = user.getUserName();
            allSubscriberName.add(name);
        }
        return allSubscriberName;
    }


//    public List<HashMap<String, String>> showChannel(){
//        List<Channel> allChannel = (List<Channel>) channelRepository.findAll();
//        List<HashMap<String, String>> listChannel = new ArrayList<>();
//
//        for (Channel channel : allChannel ){
//            HashMap<String, String> lChannel = new HashMap<>();
//            String name = channel.getChannelName();
//            String des = channel.getChannelDes();
//            String id = String.valueOf(channel.getId());
//            lChannel.put("channelName", name);
//            lChannel.put("channelDes", des);
//            lChannel.put("id", id);
//            listChannel.add(lChannel);
//        }
//        return listChannel;
//    }

    //show subcribed channel of user
    public List<HashMap<String, String>> showSubscribedChannel(int userId){
        User user = userRepository.findOne(userId);
        List<HashMap<String, String>> listChannel = new ArrayList<>();
        for (Channel channel: user.getChannel()){
            HashMap<String, String> lChannel = new HashMap<>();
            String name = channel.getChannelName();
            String des = channel.getChannelDes();
            String id = String.valueOf(channel.getId());
            lChannel.put("channelName", name);
            lChannel.put("channelDes", des);
            lChannel.put("id", id);
            listChannel.add(lChannel);
        }
        return listChannel;
    }
}
