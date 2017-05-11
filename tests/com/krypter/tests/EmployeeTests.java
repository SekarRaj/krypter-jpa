package com.krypter.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.krypter.data.Employee;

import junit.framework.TestCase;

public class EmployeeTests extends TestCase {
	private static EntityManager em;

	@Test
	public void InsertEmployees() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrmDemo");
		em = emf.createEntityManager();
		createEmployee(1, "Ravi", "Raj", "Textile");
		createEmployee(2, "Amit", "Raj", "IT");
		createEmployee(3, "Nitish", "Kumar", "Marketing");
	}

	private static void createEmployee(int id, String firstName, String lastName, String dept) {
		em.getTransaction().begin();
		Employee emp = new Employee(id, firstName, lastName, dept);
		em.persist(emp);
		em.getTransaction().commit();
	}
}