package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.DTO.UserDTO;
import uet.model.User;
import uet.service.UserService;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    //signup
//    @RequestMapping(value="/signup",method = RequestMethod.POST)
//    public User signup(@RequestBody UserDTO userDTO){
//        return userService.signup(userDTO);
//    }
//    //login
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public User login(@RequestBody UserDTO userDTO) {
//        return userService.login(userDTO);
//    }
//    //logout
//    @RequestMapping(value="/logout", method = RequestMethod.POST)
//    public User logout(@RequestBody UserDTO userDTO){
//        return userService.logout(userDTO);
//    }
}
