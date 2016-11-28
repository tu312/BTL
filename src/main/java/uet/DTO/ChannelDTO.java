package uet.DTO;

import uet.model.Post;

/**
 * Created by Tu on 12-Nov-16.
 */
public class ChannelDTO {
    private int id;
    private String channelName;
    private String channelDes;
    private Post post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }
    public String getChannelDes() {
        return channelDes;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setChannelDes(String channelDes) {
        this.channelDes = channelDes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
