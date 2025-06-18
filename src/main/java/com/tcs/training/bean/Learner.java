package com.tcs.training.bean;

//Records -> internally generates constructor and getter
//public record Learner(int id, String name, String skills) {
//
//}

public class Learner{
	private int id;
	private String name;
	private String skills;
	
	public Learner(int id, String name, String skills) {
		this.id = id;
		this.name = name;
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSkills() {
		return skills;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

		
	
}
