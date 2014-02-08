package net.feminaexlux.struts2.minimal;

import org.apache.struts2.dispatcher.DefaultActionSupport;

public class Login extends DefaultActionSupport{

    private String userName;

    private String password;

   public String execute() {
       if (userName != null && password != null && userName.equals("Lucas") && password.equals("pie")) {
           return SUCCESS;
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
