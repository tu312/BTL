package uet.DTO;

/**
 * Created by nhkha on 11/25/2016.
 */
public class NotificationDTO {
    private int id;
    private int userId;
    private String channelName;
    private int channelId;
    private String postContent;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public int setUserId(int userId){
        return this.userId = userId;
    }

    public int getChannelId() {
        return channelId;
    }

    public int setChannelId(int channelId) {
        return this.channelId = channelId;
    }

    public String getChannelName(){
        return channelName;
    }

    public String setChannelName(String channelName){
        return this.channelName = channelName;
    }

    public String getPostContent(){
        return postContent;
    }

    public String setPostContent(String postContent){
        return this.postContent = postContent;
    }

    public String getUserName(){
        return  userName;
    }

    public  String setUserName(String name){
        return this.userName = userName;
    }
}
