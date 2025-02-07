package com.example.mathservice;

import com.example.mathservice.math.MathController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class MathserviceApplicationTests {

	@Autowired
	private MathController mathController;  // Autowire the MathController

	@Test
	void contextLoads() {
		assertNotNull(mathController, "MathController should not be null");
	}

	@Test
	void testAddition() {
		double result = mathController.add(5, 3);
		assertEquals(8.0, result, "Addition result should be 8.0");
	}

	@Test
	void testSubtraction() {
		double result = mathController.subtract(5, 3);
		assertEquals(2.0, result, "Subtraction result should be 2.0");
	}

	@Test
	void testMultiplication() {
		double result = mathController.multiply(5, 3);
		assertEquals(15.0, result, "Multiplication result should be 15.0");
	}

	@Test
	void testDivision() {
		double result = mathController.divide(6, 3);
		assertEquals(2.0, result, "Division result should be 2.0");
	}

	@Test
	void testDivisionByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			mathController.divide(5, 0);
		});

		String expectedMessage = "Cannot divide by zero";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage), "Division by zero should throw ArithmeticException");
	}
}
