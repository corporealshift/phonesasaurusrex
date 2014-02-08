package net.feminaexlux.struts2.minimal.actions;

import net.feminaexlux.struts2.minimal.dao.UserDao;
import net.feminaexlux.struts2.minimal.model.User;
import org.apache.struts2.dispatcher.DefaultActionSupport;

public class Login extends DefaultActionSupport{

    private String userName;

    private String password;

    private String result;

   public String execute() {
       result = "failure";
       if (userName != null) {
            User user = UserDao.findByUserName(userName);

            if (user != null && password != null && password.equals(user.getPassword())) {
                result = "success";
            }
       }

       return SUCCESS;
   }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }
}
