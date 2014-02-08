package net.feminaexlux.struts2.minimal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "user_name")
	public String userName;

	public String password;

	public int score;

	public User() {
	}

	public User(String userName, String password, int score) {
		this.userName = userName;
		this.password = password;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
