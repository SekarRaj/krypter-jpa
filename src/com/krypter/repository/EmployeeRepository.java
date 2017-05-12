package com.krypter.repository;

import javax.inject.Inject;

import com.krypter.dal.DataAccessLayer;
import com.krypter.data.Employee;
import com.krypter.identifiers.IdentifierGenerator;

public class EmployeeRepository {
	private static volatile EmployeeRepository INSTANCE;
	private static Object lock = new Object();

	@Inject
	private IdentifierGenerator idGenerator;

	private EmployeeRepository() {
	}

	public static EmployeeRepository getInstance() {
		if (INSTANCE == null) {
			synchronized (lock) {
				if (INSTANCE == null)
					INSTANCE = new EmployeeRepository();
			}
		}
		return INSTANCE;
	}

	public void createEmployee(String firstName, String lastName, String dob) {
		DataAccessLayer.getEntityManager().getTransaction().begin();
		String id = idGenerator.generateId();
		Employee emp = new Employee(id, firstName, lastName, dob);
		DataAccessLayer.getEntityManager().persist(emp);
		DataAccessLayer.getEntityManager().getTransaction().commit();
	}
}
