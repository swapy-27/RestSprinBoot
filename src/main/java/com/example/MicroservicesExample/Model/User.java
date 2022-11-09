package com.example.MicroservicesExample.Model;

import java.time.LocalDate;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private int id;
	@Size(min=2,message="name size should be minimum of two characters")
	private String name;
	@Past(message="birthdate shpuld be in Past")
	private LocalDate birthdate;

	public User(int id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
}
