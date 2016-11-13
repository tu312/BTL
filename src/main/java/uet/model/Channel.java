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
    @ManyToMany(mappedBy = "channel")
    private Set<User> user;
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

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
