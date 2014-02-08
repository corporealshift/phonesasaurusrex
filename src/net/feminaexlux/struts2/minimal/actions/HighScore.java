package net.feminaexlux.struts2.minimal.actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HighScore extends DefaultActionSupport {

	private String user;
	private String name;
	private Integer score;

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String execute() {
		String ret = ERROR;
		Connection conn = null;

		try {
			String URL = "jdbc:mysql://localhost:3306/phoneasaurusrex";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "");
			String sql = "SELECT user_name, score FROM user ORDER BY score desc LIMIT 0,10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString(1);
				score = rs.getInt(2);
			}
				ret = SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}