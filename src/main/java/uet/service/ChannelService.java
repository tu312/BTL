package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.ChannelDTO;
import uet.model.Channel;
import uet.model.User;
import uet.repository.ChannelRepository;
import uet.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class ChannelService {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    UserRepository userRepository;

    //create channel
    public Channel createChannel(int userId, ChannelDTO channelDTO){
        User user = userRepository.findOne(userId);
        if ( user.getStatus() == 1 ){
            Channel channel = channelRepository.findByChannelName(channelDTO.getChannelName());
            if ( channel == null && channelDTO.getChannelName() != null ){
                Channel channel1 = new Channel();
                channel1.setChannelName(channelDTO.getChannelName());
                channel1.setChannelDes(channelDTO.getChannelDes());
                user.getChannel().add(channel1);
                return channelRepository.save(channel1);
            } else {
                throw new NullPointerException("Channel existed.");
            }
        } else {
            throw new NullPointerException("Log in first!");
        }
    }

    //join channel
    public void joinChannel(int userId, int channelId){
        User user = userRepository.findOne(userId);
        int count = 0;
        if ( user.getStatus() == 1 ) {
            for (Channel sChannel : user.getChannel()) {
                if (sChannel.getId() == channelId) {
                    count = 1;
                    break;
                }
            }
            if(count == 0) {
                Channel channel = channelRepository.findOne(channelId);
                user.getChannel().add(channel);
                userRepository.save(user);
            }
        }else {
            throw new NullPointerException("Log in first!");
        }
    }


    //show all channels
    public List<HashMap<String, String>> showChannel(){
        List<Channel> allChannel = (List<Channel>) channelRepository.findAll();
        List<HashMap<String, String>> listChannel = new ArrayList<>();

        for (Channel channel : allChannel ){
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

    //show a channel
    public Channel showChannel(int channelId){
        Channel channel = channelRepository.findOne(channelId);
        return channel;
    }



}
