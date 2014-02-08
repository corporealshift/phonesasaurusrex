package net.feminaexlux.struts2.minimal.dao;

import net.feminaexlux.struts2.minimal.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User("Lucas","pie", 0));
    }

    public static User findByUserName(String userName) {
        for (User user: users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }

        return null;
    }
}
