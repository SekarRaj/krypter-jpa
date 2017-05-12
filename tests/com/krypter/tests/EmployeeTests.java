package com.krypter.tests;

import com.krypter.repository.EmployeeRepository;

import junit.framework.TestCase;

public class EmployeeTests {

	public static void main(String... dept) {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		repo.createEmployee("Shanthi", "Sudha", "12/12/2012");
	}
}