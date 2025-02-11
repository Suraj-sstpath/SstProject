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
    public Employee findEmployeeById(Integer id)
    {
    	
    	  Optional<Employee> byId = repo.findById(id);
    	  if(byId.isPresent())
    	  {
    		          Employee employee = byId.get();
    		          return employee;
    	  }
    	  
    	   return null;
    	  
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
  
  
  
  
  
  
}
