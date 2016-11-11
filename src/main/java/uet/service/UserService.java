package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import uet.model.User;
import uet.repository.UserRepository;

/**
 * Created by Tu on 11-Nov-16.
 */
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User signup(User userDTO){
        User user1  = userRepository.findByUserName(userDTO.getUsername());
        if (user1 == null){
            if(userDTO.getUsername() != null && userDTO.getPassword() != null){
                User user = new User();
                user.setUsername(userDTO.getUsername());
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

    public User login(User userDTO){
        User user = userRepository.findByUserName(userDTO.getUsername());
        if (userDTO.getPassword().equals(user.getPassword())){
            user.setStatus(1);
            return userRepository.save(user);
        } else {
            throw new NullPointerException("Wrong password.");
        }
    }

    public User logout(User user){
        user.setStatus(0);
        return userRepository.save(user);
    }
}
