package com.lhu.jersey.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lhu.jersey.entities.Employee;


public class EmployeeRepository {
	
	ArrayList<Employee> al;
	Connection con;
	
	public EmployeeRepository(){
		String url = "jdbc:mysql://localhost:3306/JerseyRestCompay";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql = "select employeeId,employeeName,employeeAge,employeeAddress from employee";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			Employee em = null;
			while(rs.next()){
				em = new Employee();
				
				em.setEmployeeId(rs.getInt("employeeId"));
				em.setEmployeeName(rs.getString("employeeName"));//(rs.getString(1));
				em.setEmployeeAge(rs.getInt("employeeAge"));
				em.setEmployeeAddress(rs.getString("employeeAddress"));	
				
				list.add(em);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public Employee getEmployee(int id) {
		String sql = "select employeeId,employeeName,employeeAge,employeeAddress from employee where employeeId = "+id;
		Employee em = new Employee();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				em.setEmployeeId(rs.getInt("employeeId"));
				em.setEmployeeName(rs.getString("employeeName"));//(rs.getString(1));
				em.setEmployeeAge(rs.getInt("employeeAge"));
				em.setEmployeeAddress(rs.getString("employeeAddress"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return em;
	}
	
	
	public List<Employee> createEmployee(Employee em){
		System.out.println("INSIDE ALIEN CREATE DAO");
		String sql = "insert into employee (employeeName,employeeAge,employeeAddress) values(?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,em.getEmployeeName());
			st.setInt(2, em.getEmployeeAge());
			st.setString(3,em.getEmployeeAddress() );
			//st.setInt(2, al.getPoints());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getEmployees();
		
	}
	
	public List<Employee> updateEmployee(Employee em){
		String sql = "update employee set employeeName=? where employeeId = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,em.getEmployeeName());
			st.setInt(2, em.getEmployeeId());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getEmployees();
	}
	
	public List<Employee> deleteEmployee(int id){
		String sql = "delete from employee where employeeId = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getEmployees();
	}
	
}
//JerseyRestCompay
