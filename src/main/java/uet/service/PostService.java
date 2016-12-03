package uet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.DTO.PostDTO;
import uet.model.Channel;
import uet.model.Post;
import uet.model.User;
import uet.repository.ChannelRepository;
import uet.repository.PostRepository;
import uet.repository.UserRepository;

import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;

    //create post
    public Post createPost(int userId, int channelId, PostDTO postDTO){
        User user = userRepository.findOne(userId);
        Channel channel = channelRepository.findOne(channelId);
        if (user.getStatus() == 1){
            Post post = new Post();
            post.setContent(postDTO.getContent());
            post.setUserName(user.getUserName());
            postRepository.save(post);
            channel.getPost().add(post);
            channelRepository.save(channel);
            return post;
        } else {
            throw new NullPointerException("Log in first!");
        }
    }

    // show list post of a channel
    public List<Post> listPost(int channelId){
        Channel channel = channelRepository.findOne(channelId);
        return channel.getPost();
    }

    //show a post
    public Post showPost(int postId){
        Post post = postRepository.findOne(postId);
        return post;
    }
}
