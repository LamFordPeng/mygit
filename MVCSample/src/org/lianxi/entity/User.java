package org.lianxi.entity;

//封装数据的模型——实体类

public class User {
	private int id;
	private String name;
	private String pwd;

	public User() {
	}

	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public User(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
