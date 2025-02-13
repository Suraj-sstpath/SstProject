package com.sst.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sst.model.Employee;
//Implementing the interface
public interface IService
{
	//Abstract Method For The Register New Employee 
	public String registerEmploye(Employee employee);
	
     //Abstract method for the Rendering all Data 
	  public List<Employee>fetchAllEmployee();
	  
	  //Search The Employee by the Id Number 
	  public String findEmployeeById(Integer id);
	  
	  //Search The  Employee By Name
	  public String findByName(String name);
	  
	  //Implements the default method  for the delete by id 
	  public String deleteById(Integer id);
	  
	  //Implements the  default method for the find the range of id 
	  List<Employee> findOrdersByIdRange(Long startId,Long endId);
	  
	  
	  
	  //Update The Employee Details Based On the Id 
	  public String updateEmployeeDetailsBasedOnTheId(Employee employee);
	  
	  //Implements the method for the find the salary between the range 
	  List<Employee> findBalanceAmountBetweenTheRange( Double startId, Double endId);
		 
	  
	  
	  
	  
	  
}
