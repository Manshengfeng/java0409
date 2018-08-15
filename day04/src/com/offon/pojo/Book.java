package com.offon.pojo;

public class Book {
	private String name;
	private int age;
	private User user;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book(String name, int age, User user) {
		super();
		this.name = name;
		this.age = age;
		this.user = user;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", age=" + age + ", user=" + user + "]";
	}
	public void acy(){
		System.out.println("–°√√√√øÏ¿¥≈∂");
		user.action();
	}

}
