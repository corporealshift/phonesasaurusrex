package net.feminaexlux.struts2.minimal.actions;

import net.feminaexlux.struts2.minimal.dao.UserDao;
import net.feminaexlux.struts2.minimal.model.User;
import org.apache.struts2.dispatcher.DefaultActionSupport;

public class Login extends DefaultActionSupport{

    private String userName;

    private String password;

   public String execute() {
       if (userName != null) {
            User user = UserDao.findByUserName(userName);

            if (user != null && password != null && password.equals(user.getPassword())) {
                return SUCCESS;
            }
       }
       return INPUT;
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
}
