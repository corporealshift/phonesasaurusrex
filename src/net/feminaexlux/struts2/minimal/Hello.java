package net.feminaexlux.struts2.minimal;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import java.util.Date;

public class Hello extends DefaultActionSupport {
	private String name;

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
