package net.feminaexlux.struts2.minimal.actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighScore extends DefaultActionSupport {

    private List<Map<String, String>> highScores;
    private String result;

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
        highScores = new ArrayList<Map<String, String>>();
		try {
			String URL = "jdbc:mysql://localhost:3306/phoneasaurusrex";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "");
			String sql = "SELECT user_name, score FROM user ORDER BY score desc LIMIT 0,10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
                Map<String, String> user = new HashMap<String, String>();

                user.put("userName", rs.getString(1));
                user.put("score", "" + rs.getInt(2));

                highScores.add(user);
			}
				result = "success";

		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}





		return SUCCESS;
	}

    public List<Map<String, String>> getHighScores() {
        return highScores;
    }

    public String getResult() {
        return result;
    }
}