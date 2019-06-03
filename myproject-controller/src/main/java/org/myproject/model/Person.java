package org.myproject.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7707863267845573072L;

	@Valid
	private List<Skill> skills;
	
	@NotBlank(message = "name不能为空")
	private String name;
	
	
	@NotNull(message = "age不能为空")
	@Max(value = 150,message = "age不能大于150")
	@Min(value = 10,message = "age不能小于10")
	private Integer age;
	
	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [skills=" + skills + ", name=" + name + ", age=" + age + "]";
	}
	
}
