package com.sst.service;

import java.util.List;

import com.sst.model.Employee;
//Implementing the interface
public interface IService
{
	//Abstract Method For The Register New Employee 
	public String registerEmploye(Employee employee);
	
     //Abstract method for the Rendering all Data 
	  public List<Employee>fetchAllEmployee();
	  
	  //Search The Employee by the Id Number 
	  public Employee findEmployeeById(Integer id);
	  
	  //Search The  Employee By Name
	  public String findByName(String name);
	  
}
