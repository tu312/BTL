package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import uet.model.Channel;
import uet.repository.ChannelRepository;
import uet.repository.UserRepository;

/**
 * Created by Tu on 11-Nov-16.
 */
public class ChannelService {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    UserRepository userRepository;
    public Channel createChannel(Channel channelDTO){
        Channel channel = channelRepository.findByChannelName(channelDTO.getChannelName());
        if (channel == null){
            channel.setChannelName(channelDTO.getChannelName());
            return channelRepository.save(channel);
        } else {
            throw new NullPointerException("Channel existed.");
        }
    }

}
