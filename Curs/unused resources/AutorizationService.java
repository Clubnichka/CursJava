package pack.Services;
import org.springframework.stereotype.Service;
import pack.beans.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class AutorizationService {
    private static List<User> userList;
    public AutorizationService(){
        userList=new ArrayList<>();
        User u=new User();
        u.setName("User");
        u.setPassword("pass");
        u.setRole(0);
        u.setId(10000);
        userList.add(u);
        u=new User();
        u.setName("User1");
        u.setPassword("pass1");
        u.setRole(2);
        u.setId(100);
        userList.add(u);
        u=new User();
        u.setName("User2");
        u.setPassword("pass2");
        u.setRole(1);
        u.setId(0);
        userList.add(u);
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void removeUser(User user){
        userList.remove(user);
    }
    public void removeUser(String username){
        for (User i:userList){
            if (i.getName()==username){
                userList.remove(i);
                break;
            }
        }
    }
    public List<User> getUserList(){

        return this.userList;
    }
    public User Enter(String name, String password){
        if (name==null||password==null){
            User nofound=new User();
            nofound.setName("False");
            nofound.setPassword("False");
            nofound.setRole(998);
            return nofound;
        }
        for (User user:userList){
            if ((user.getPassword()==password)&&(user.getName()==name)){
                return user;
            }
        }
        return null;
    }
    public void removeUser(int id){
       userList.removeIf(x->x.getId()==id);
    }
}
