package com.sst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.model.Employee;
import com.sst.repository.IEmployeeRepo;
@Service
public class ServiceProvider implements IService 
{
	@Autowired
	private IEmployeeRepo repo;
	
	
  @Override
  public String registerEmploye(Employee employee)
{
	
	  
	  Employee register  = repo.save(employee);
	      return "Employee is register with the Id "+register.getIds();
}//end method 
  
  
  
  //Implement the method for rendering all the data 
  @Override
  public List<Employee> fetchAllEmployee()
  { 
	  //invoked the method 
	     return repo.findAll();
   }//end method 
  
  
  
  
      @Override
    public String findEmployeeById(Integer id)
    {
    	
    	  Optional<Employee> byId = repo.findById(id);
    	  if(byId.isPresent())
    	  {
    		          Employee employee = byId.get();
    		          return employee.toString();
    	  }
    	  
    	   return id+" is not present in the DataBase ";
    	  
    }
  
     @Override
    public String findByName(String name)
    {
    	
    	      Optional<Employee> byName = repo.findByName(name);
    	      if(byName.isPresent())
    	      {
    	    	    Employee employee = byName.get();
    	    	    return employee.toString();
    	    	    
    	      }
    	      else 
    	      {
    	    	  return "Name Not Found In The Table ";
    	      }
    	   
    	    			  
    }
  
    
     //Override the default method   
     @Override
     public String deleteById(Integer id) 
     {
    	 
         Optional<Employee> employee = repo.findById(id);
         if (employee.isPresent())
         {
             repo.deleteById(id);
             return "Employee with ID " + id + " has been successfully deleted.";
         }
         else
         {
             return "Employee with ID " + id + " not found.";
         }
     }
	 
    	 
    	 
    	
    //Custom method for the find the range of the id
    @Override
    public List<Employee> findOrdersByIdRange(Long startId, Long endId)
    {
    	
         List<Employee> ordersByIdRange = repo.findOrdersByIdRange(startId, endId);
         return ordersByIdRange;
    	
    }
  
  
    
    //update The  Employee Information  based on the Id 
    @Override
    public String updateEmployeeDetailsBasedOnTheId(Employee employee)
    {
        // Ensure the employee ID is not null
        if (employee.getIds() == null)
        {
            return "Employee ID is required to update details.";
        }

        // Attempt to find the employee by ID
        Optional<Employee> existingEmployee = repo.findById(employee.getIds());

        // Check if the employee exists in the repository
        if (existingEmployee.isPresent())
        {
            // If employee exists, update and save the new data
            Employee updatedEmployee = repo.save(employee);
            return "Employee data updated successfully with ID: " + updatedEmployee.getIds();
        }

        // If the employee does not exist, return an appropriate message
        return "Employee with ID " + employee.getIds() + " not found in the database.";
    }
  
     
    
    //Develop the method for finding the Employee based on the Balance Amount 
    @Override
    public List<Employee> findBalanceAmountBetweenTheRange(Double startId, Double endId)
    {
        // Fetch the list of employees whose balance amounts are between the given range
        List<Employee> balanceAmountBetweenTheRange = repo.findBalanceAmountBetweenTheRange(startId, endId);
        
        // Return the list of employees
        return balanceAmountBetweenTheRange;
    }
    
    
    
    
    
    
    
}
