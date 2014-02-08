package net.feminaexlux.struts2.minimal.actions;

import net.feminaexlux.struts2.minimal.dao.UserDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Hello extends DefaultActionSupport {
	private String name;

	@Autowired
	private UserDao userDao;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Date getToday() {
		return new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
