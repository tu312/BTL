package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.DTO.ChannelDTO;
import uet.model.Channel;
import uet.service.ChannelService;

import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    //create a channel (user who created a channel will automatically join that channel)
    @RequestMapping(value="user/{userId}/createChannel", method = RequestMethod.POST)
    public Channel createChannel(@PathVariable("userId") int userId, @RequestBody ChannelDTO channelDTO){
        return channelService.createChannel(userId, channelDTO);
    }

    //join a channel
    @RequestMapping(value="user/{userId}/joinChannel/{channelId}", method = RequestMethod.POST)
    public void joinChannel(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId){
        channelService.joinChannel(userId, channelId);
    }

    //show all channels
    @RequestMapping(value="/channel", method = RequestMethod.GET)
    public List<Channel> showChannel() {
        return channelService.showChannel();
    }

}
