package uet.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    @Autowired private SimpMessagingTemplate simpMessagingTemplate;

    //create post
    @RequestMapping(value = "user/{userId}/channel/{channelId}/post", method = RequestMethod.POST)
    public void createPost(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId, @RequestBody PostDTO postDTO)  throws Exception {
        Post post = postService.createPost(userId, channelId, postDTO);
        simpMessagingTemplate.convertAndSend("/topic/listen", post);


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

//    @MessageMapping("/user/{userId}/channel/{channelId}/post")
//
//    public Greeting greet(@DestinationVariable String room, HelloMessage message) throws Exception {
//        Greeting greeting = new Greeting("Hello, " + message.getName() + "!");
//        this.template.convertAndSend("/topic/room/"+room, greeting);
//    }

}
//dang can lam: luu vao post va gui ngc lai client cai post vua luu qua socket ma client lang nghe