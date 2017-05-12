package com.krypter.repository;

import javax.inject.Inject;

import com.krypter.data.Employee;
import com.krypter.identifiers.IdentifierGenerator;

public class EmployeeRepository {
	public static volatile EmployeeRepository INSTANCE = EmployeeRepository.createInstance();
	private static Object lock = new Object();

	private EmployeeRepository() {
	}

	@Inject
	IdentifierGenerator idGenerator;

	private static EmployeeRepository createInstance() {
		if (INSTANCE != null) {
			return INSTANCE;
		} else {
			synchronized (lock) {
				return new EmployeeRepository();
			}
		}
	}

	public EmployeeRepository getInstance() {
		return EmployeeRepository.createInstance();
	}

	public void createEmployee(String firstName, String lastName, String dob) {
		Employee emp = new Employee(idGenerator.generateId(), firstName, lastName, dob);

	}
}
