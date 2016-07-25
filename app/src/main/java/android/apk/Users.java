package android.apk;

/**
 * Created by ABVN237 on 7/20/2016.
 */
public class Users {
    String username;
    String password;

    public Users(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
