package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uet.service.UserService;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
}
