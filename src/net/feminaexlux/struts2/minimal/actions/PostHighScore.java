package net.feminaexlux.struts2.minimal.actions;

import net.feminaexlux.struts2.minimal.dao.UserDao;
import net.feminaexlux.struts2.minimal.model.User;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.json.simple.JSONObject;

public class PostHighScore extends DefaultActionSupport {

    private String userName;

    private int score;

    private String result;


    public String execute() {
        User user = UserDao.findByUserName(userName);

        result = "failure";
        if (user != null) {
            user.setScore(score);
            result = "success";
        }

        return SUCCESS;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }
}
