package com.lhu.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lhu.jersey.entities.Department;
import com.lhu.jersey.entities.Employee;
import com.lhu.jersey.repositories.DepartmentRepository;
import com.lhu.jersey.repositories.EmployeeRepository;



@Path("Company")
public class CompanyResource {

///////////////////////////////////// for employee request //////////////////////////////////////////
	//--------------------  In here we use JDBC in EmployeeRepository  ------------------------------
	EmployeeRepository employeeRepository = new EmployeeRepository();

	@GET
	@Path("employee")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Employee> getEmployeesGet() { 
		System.out.println("CompanyResource : getEmployeesGet()");
		return employeeRepository.getEmployees();
	}
	@POST
	@Path("employee")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Employee> getEmployeePost() {
		System.out.println("CompanyResource : getEmployeePost()");
		return employeeRepository.getEmployees();
	}

	@GET
	@Path("employee/{id}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Employee getEmployee(@PathParam("id") int id) {
		System.out.println("CompanyResource : getEmployee(@PathParam('id') int id)");
		return employeeRepository.getEmployee(id);
	}

	
	@POST
	@Path("employee/addaEmployee")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Employee> createEmployee(Employee em) {
		System.out.println("CompanyResource : createEmployee(Employee em)");
		return employeeRepository.createEmployee(em);	
	}
	
	@PUT
	@Path("employee/updateEmployee")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Employee> updateAlien(Employee em) {
		System.out.println("CompanyResource : updateAlien(Employee em)");
		return employeeRepository.updateEmployee(em);
	}
	
	@DELETE
	@Path("employee/deleteEmployee/{id}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Employee> killAlien(@PathParam("id") int id) {
		System.out.println("CompanyResource : killAlien(@PathParam('id') int id)");		
		return employeeRepository.deleteEmployee(id);
	}
	
	///////////////////////////////////// for department request //////////////////////////////////////////
	
	//-------------------- In here we use HIBERNATE in DepartmentRepository  ------------------------------
	DepartmentRepository departmentRepository = new DepartmentRepository();
	
	@GET
	@Path("department")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Department> getDepartmentGet() { 
		System.out.println("CompanyResource : getDepartmentGet())");
		return departmentRepository.getDepartments();
	}
	@POST
	@Path("department")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Department> getDepartmentPost() {
		System.out.println("CompanyResource : getDepartmentPost()");
		return departmentRepository.getDepartments();
	}

	@GET
	@Path("department/{id}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Department getDepartment(@PathParam("id") int id) {
		System.out.println("CompanyResource : getDepartment(@PathParam('id') int id)");
		return departmentRepository.getDepartment(id);
	}

	
	@POST
	@Path("department/addaDepartment")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Department> createDepartment(Department department) {
		System.out.println("CompanyResource : createDepartment(Department department)");
		return departmentRepository.createDepartment(department);		
	}
	
	@PUT
	@Path("department/updateDepartment")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Department> updateDepartment(Department department) {
		System.out.println("CompanyResource : updateDepartment(Department department)");
		return departmentRepository.updateDepartment(department);
	}
	
	@DELETE
	@Path("department/deleteDepartment")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Department> killDepartment(Department department) {
		System.out.println("CompanyResource : killDepartment(Department department)");
		return departmentRepository.deleteDepartment(department);
	}
	
	
}
//JerseyRestCompay
