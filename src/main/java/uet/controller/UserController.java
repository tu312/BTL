package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.model.User;
import uet.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //signup
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public User signup(@RequestBody User user){
        return userService.signup(user);
    }
    //login
    @RequestMapping(value="login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
    //logout
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public User logout(@RequestBody User user){
        return userService.logout(user);
    }
}
