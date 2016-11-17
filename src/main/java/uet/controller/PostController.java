package uet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.DTO.PostDTO;
import uet.model.Post;
import uet.service.PostService;

import java.util.List;

/**
 * Created by Tu on 11-Nov-16.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    //create post
    @RequestMapping(value = "user/{userId}/channel/{channelId}/post", method = RequestMethod.POST)
    public Post createPost(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId, @RequestBody PostDTO postDTO){
        return postService.createPost(userId, channelId, postDTO);
    }

    //show list post of a channel
    @RequestMapping(value = "channel/{channelId}/listpost", method = RequestMethod.GET)
    public List<Post> listPost(@PathVariable("channelId") int channelId){
        return postService.listPost(channelId);
    }

    //show a post
    @RequestMapping(value = "post/{postId}", method = RequestMethod.GET)
    public Post showPost(@PathVariable("postId") int postId){
        return postService.showPost(postId);
    }

}
