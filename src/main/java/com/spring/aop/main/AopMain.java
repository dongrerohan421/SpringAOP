package com.spring.aop.main;

import com.spring.aop.service.FactoryService;
import com.spring.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {

		try {

			// ApplicationContext context = new
			// ClassPathXmlApplicationContext("springAOP.xml");

			// Used "ShapeService.class" to type cast it automatically according
			// to class
			// ShapeService shapeService = context.getBean("shapeService",
			// ShapeService.class);
			// shapeService.getCircle().setName("Dummy Circle setter");
			// shapeService.getCircle().setNameAndReturn("Dummy Circle
			// setNameAndReturn");
			// System.out.println(shapeService.getCircle().getName());
			// System.out.println(shapeService.getTriangle().getName());

			FactoryService factoryService = new FactoryService();
			ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService;");
			shapeService.getCircle();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
