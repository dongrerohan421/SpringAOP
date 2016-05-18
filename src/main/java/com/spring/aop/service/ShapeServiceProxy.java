package com.spring.aop.service;

import com.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		return super.getCircle();
	}
}
