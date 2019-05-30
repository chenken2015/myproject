package org.myproject.model;

import javax.validation.constraints.NotBlank;

public class Skill {

	@NotBlank(message = "不能为空")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
