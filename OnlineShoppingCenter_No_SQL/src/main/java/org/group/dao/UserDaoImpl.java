package org.group.dao;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.group.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by lincolnz9511 on 16-11-26.
 */
@Repository
public class UserDaoImpl implements UserDao {

    public User findByName(String username) {
        List<User> userList = new ArrayList<User>();
        String passUser1 = new Md5Hash("13579","Lady@sysu.cn").toString();
        String passUser2 = new Md5Hash("02468", "Man@sysu.cn").toString();
        User user1 = new User("Lady@sysu.cn", passUser1, 0.95, "1");
        User user2 = new User("Man@sysu.cn", passUser2, 1, "0");
        userList.add(user1);
        userList.add(user2);

        for (User u: userList) {
            if(u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
