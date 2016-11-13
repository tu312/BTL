package uet.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Tu on 10-Nov-16.
 */
@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private int status;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Channel> channel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Channel> getChannel() {
        return channel;
    }

    public void setChannel(Set<Channel> channel) {
        this.channel = channel;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
