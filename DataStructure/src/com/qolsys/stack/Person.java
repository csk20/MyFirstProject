package com.qolsys.stack;

public class Person {

	private int rollno;
	
	private String name;

	public Person(int rollno, String name) {
		super();
		this.rollno = rollno;
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [rollno=" + rollno + ", name=" + name + "]";
	}
	
	
}
