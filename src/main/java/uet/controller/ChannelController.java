package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.DTO.ChannelDTO;
import uet.model.Channel;
import uet.service.ChannelService;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    //create a channel
    @RequestMapping(value="/createChannel", method = RequestMethod.POST)
    public Channel createChannel(@RequestBody ChannelDTO channelDTO){
        return channelService.createChannel(channelDTO);
    }

    //join a channel
    @RequestMapping(value="user/{userId}/joinChannel/{channelId}", method = RequestMethod.POST)
    public void joinChannel(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId){
        channelService.joinChannel(userId, channelId);
    }
}
