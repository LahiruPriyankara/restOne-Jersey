package com.lhu.jersey.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.lhu.jersey.entities.Department;

public class DepartmentRepository {
	
	
	public static Session sessionBulder(){
		Configuration con = new Configuration().configure().addAnnotatedClass(Department.class);		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf.openSession();
	}
	
	public static Session session = null;
	
	public List<Department> getDepartments() {
		session = DepartmentRepository.sessionBulder();
		Transaction tx = session.beginTransaction();
		List<Department> departments = new ArrayList<>();
		
		try {
			Query query = session.createQuery("from Department");
		    departments = query.list();
		    
		    tx.commit();
			session.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return departments;
	}

	public Department getDepartment(int id) {
		session = DepartmentRepository.sessionBulder();
		Transaction tx = session.beginTransaction();
		String hql = "from Department where departmentId = "+id;
		Department department = new Department();
		try {
			Query query = session.createQuery(hql);
			department = (Department)query.uniqueResult();
			
			tx.commit();
			session.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return department;
	}
	
	
	public List<Department> createDepartment(Department department){
		session = DepartmentRepository.sessionBulder();
		Transaction tx = session.beginTransaction();
		try {
			session.save(department);
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDepartments();
	}
	
	public List<Department> updateDepartment(Department department){
		session = DepartmentRepository.sessionBulder();
		Transaction tx = session.beginTransaction();
		try {
			session.update(department);
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return getDepartments();
	}
	
	public List<Department> deleteDepartment(Department department){
		session = DepartmentRepository.sessionBulder();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(department);
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDepartments();
	}
	
}
//JerseyRestCompay

	
	
	
	