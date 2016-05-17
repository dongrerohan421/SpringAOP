package com.spring.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {

		try {

			ApplicationContext context = new ClassPathXmlApplicationContext("springAOP.xml");

			// Used "ShapeService.class" to type cast it automatically according
			// to class
			ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
			shapeService.getCircle().setName("Circle setter");
			System.out.println(shapeService.getCircle().getName());
			// System.out.println(shapeService.getTriangle().getName());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
