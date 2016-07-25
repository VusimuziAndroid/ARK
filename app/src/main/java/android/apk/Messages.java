package android.apk;

/**
 * Created by Vusi Ngwenya on 7/20/2016.
 */
public class Messages {
    String username;
    String cellNumbers;
    String message;

    public Messages(String username,String cellNumbers,String message){
        this.username=username;
        this.cellNumbers=cellNumbers;
        this.message=message;
    }
    public String getUsername(){
        return this.username;
    }
    public String getCellNumbers(){
        return this.message;
    }
    public String getMessage(){
        return this.message;
    }
}
