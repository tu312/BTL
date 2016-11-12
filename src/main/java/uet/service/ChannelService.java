package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.ChannelDTO;
import uet.model.Channel;
import uet.model.User;
import uet.repository.ChannelRepository;
import uet.repository.UserRepository;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class ChannelService {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    UserRepository userRepository;
    public Channel createChannel(ChannelDTO channelDTO){
        Channel channel = channelRepository.findByChannelName(channelDTO.getChannelName());
        if (channel == null){
            channel.setChannelName(channelDTO.getChannelName());
            return channelRepository.save(channel);
        } else {
            throw new NullPointerException("Channel existed.");
        }
    }

    public void joinChannel(int userId, int channelId){
        User user = userRepository.findOne(userId);
        Channel channel = channelRepository.findOne(channelId);
        user.getChannel().add(channel);
        userRepository.save(user);
    }
}
