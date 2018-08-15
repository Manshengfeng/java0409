package com.offon.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.Property;

public class User {
	private String name;
	private int age;
	private List<Book>listbook;
	private Set<Book>set;
	private Map<String,String>map;
	private Property p;
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
	public List<Book> getListbook() {
		return listbook;
	}
	public void setListbook(List<Book> listbook) {
		this.listbook = listbook;
	}
	public Set<Book> getSet() {
		return set;
	}
	public void setSet(Set<Book> set) {
		this.set = set;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Property getP() {
		return p;
	}
	public void setP(Property p) {
		this.p = p;
	}
	public User(String name, int age, List<Book> listbook, Set<Book> set,
			Map<String, String> map, Property p) {
		super();
		this.name = name;
		this.age = age;
		this.listbook = listbook;
		this.set = set;
		this.map = map;
		this.p = p;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", listbook=" + listbook
				+ ", set=" + set + ", map=" + map + ", p=" + p + "]";
	}
	public void action(){
		System.out.println("这是user的方法");
	}

}
