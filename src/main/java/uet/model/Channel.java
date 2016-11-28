package uet.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Tu on 10-Nov-16.
 */
@Entity
@Table(name="Channel")
public class Channel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String channelName;
    private String channelDes;
    //    @ManyToMany(mappedBy = "channel")
//    private List<User> user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDes() {
        return channelDes;
    }

    public void setChannelDes(String channelDes) {
        this.channelDes = channelDes;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

//    public List<User> getUser() {
//        return user;
//    }
//
//    public void setUser(List<User> user) {
//        this.user = user;
//    }
}
