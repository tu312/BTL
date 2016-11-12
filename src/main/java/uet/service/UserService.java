package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.UserDTO;
import uet.model.User;
import uet.repository.UserRepository;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public User signup(UserDTO userDTO){
//        User user1  = userRepository.findByUserName(userDTO.getUserName());
//        if (user1 == null){
//            if(userDTO.getUserName() != null && userDTO.getPassword() != null){
//                User user = new User();
//                user.setUserName(userDTO.getUserName());
//                user.setPassword(userDTO.getPassword());
//                user.setStatus(0);
//                return userRepository.save(user);
//            } else {
//                throw new NullPointerException("Missing information.");
//            }
//        } else {
//            throw new NullPointerException("User existed.");
//        }
//    }
//
//    public User login(UserDTO userDTO){
//        User user = userRepository.findByUserName(userDTO.getUserName());
//        if (userDTO.getPassword().equals(user.getPassword())){
//            user.setStatus(1);
//            return userRepository.save(user);
//        } else {
//            throw new NullPointerException("Wrong password.");
//        }
//    }
//
//    public User logout(UserDTO userDTO){
//        User user = userRepository.findByUserName(userDTO.getUserName());
//        user.setStatus(0);
//        return userRepository.save(user);
//    }
}
