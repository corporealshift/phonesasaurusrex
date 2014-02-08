package net.feminaexlux.struts2.minimal.dao;

import net.feminaexlux.struts2.minimal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	@PersistenceContext
	protected EntityManager em;

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
