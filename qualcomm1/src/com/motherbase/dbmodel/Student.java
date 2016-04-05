package com.motherbase.dbmodel;

public class Student {
	public String email;
	public String name;
	private String password;
	private String description;
	private int karma;
	
	public void setEmail(String email) { this.email = email; }
	
	public void setName(String name) { this.name = name; }
	
	public void setDescription(String description) { this.description = description; }
	
	public void setKarma(int karma) { this.karma = karma; }	
	
	public void setPassword(String password){this.password = password;}

	public String getEmail() { return email; }

	public String getName() { return name; }

	public String getDescription() { return description; }

	public int getKarma() { return karma; }
	
	public String getPassword() {return password;}
}
