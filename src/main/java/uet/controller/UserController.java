package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.DTO.UserDTO;
import uet.model.User;
import uet.service.UserService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //signup
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public User signup(@RequestBody UserDTO userDTO){
        return userService.signup(userDTO);
    }

    //login
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public User login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    //logout
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public User logout(@RequestBody UserDTO userDTO){
        return userService.logout(userDTO);
    }

    //show list subscriber of a channel
    @RequestMapping(value="/channel/{channelId}/subscriber", method = RequestMethod.GET)
    public List<String> showSubscriber(@PathVariable("channelId") int channelId){
        return userService.showSubscriber(channelId);
    }

    //show subcribed channel of user
    @RequestMapping(value="/user/{userId}/subscribed", method = RequestMethod.GET)
    public List<HashMap<String, String>> showSubscribedChannel(@PathVariable("userId") int userId){
        return userService.showSubscribedChannel(userId);
    }
}
