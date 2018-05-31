package bangbanggokgok.com.com.com.mobile_project;

import java.util.ArrayList;

/**
 * Created by User on 2018-06-01.
 */

public class UserDTO {
    public  String name;
    public  String email;
    public  ArrayList<Integer> info = null;

    public UserDTO(String name, String email){
        this.name = name;
        this.email = email;
    }
    public void addInfo(int num){
        info.add(num);
    }

}
