package com.krypter.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.krypter.data.Employee;

import junit.framework.TestCase;

public class EmployeeTests extends TestCase {
	private static EntityManager em;

	public static void main(String... dept) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("krypter-jpa");
		em = emf.createEntityManager();
		createEmployee("E123", "Ravi", "Raj", "Textile");
		// createEmployee(2, "Amit", "Raj", "IT");
		// createEmployee(3, "Nitish", "Kumar", "Marketing");
	}

	private static void createEmployee(String id, String firstName, String lastName, String dept) {
		em.getTransaction().begin();
		Employee emp = new Employee(id, firstName, lastName, dept);
		em.persist(emp);
		em.getTransaction().commit();
	}
}