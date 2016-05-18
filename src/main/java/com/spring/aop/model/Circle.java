package com.spring.aop.model;

public class Circle {

	private String name;

	public String getName() {
		System.out.println("Circle's getter called.");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called.");
		throw (new RuntimeException());
	}

	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setNameAndReturn called.");
		return name;
	}
}
