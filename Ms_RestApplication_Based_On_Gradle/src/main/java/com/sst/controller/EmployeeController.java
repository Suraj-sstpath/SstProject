package com.sst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.model.Employee;
import com.sst.service.IService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//Developing the RestController class 
@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	
	//target to dependent class 
      @Autowired
	  private IService service;
      
      @Operation(summary = "Creat new user ",description = "Insert the new employee in the data based ")
      @ApiResponse(responseCode ="201",description = "Succesfully created user")
      //Implementing the API for the Register the new Employee 
      @PostMapping("/insert")
	  public ResponseEntity<?>registerNewEmployee(@RequestBody Employee employee)
	  {
		  
		  
		  try
		  {
			  //Invoked the BLC Method 
			    String registerEmployee = service.registerEmploye(employee);
			    
			  return new ResponseEntity<String>(registerEmployee,HttpStatus.CREATED);
			  
		  }
		  catch (Exception e)
		  {
			
			e.printStackTrace();
			return new ResponseEntity<String>("Please Cheak Method Implementation Carefully ",HttpStatus.INTERNAL_SERVER_ERROR);
			  
			  
		  }//end try catch 
		  
		  
	  }//end register method 
	
	
      
      @Operation(summary = "Employee Details ",description = "fetched All Employee By Id  ")
      @ApiResponse(responseCode = "200",description = "Successfully retrived the data ")
      //Implement the method for rendering all the data 
      @GetMapping("/all")
      public ResponseEntity<?>employeeData()
      {
    	  try
    	  {
    		  List<Employee> fetchAllEmployee = service.fetchAllEmployee();
    		  return new ResponseEntity<List<Employee>>(fetchAllEmployee,HttpStatus.ACCEPTED);
    		  
    	  }
    	  catch (Exception e)
    	  {
			 e.printStackTrace();
			 return new ResponseEntity<String>("Please Cheak The Method Implementation ",HttpStatus.INTERNAL_SERVER_ERROR);
		  }
      }
      
       
      
      
      //Implementing the Find Employee Based On The Id API
      @Operation(summary = "Find by id ",description = "Search Employee By id ")
      @GetMapping("/find/{id}")
      public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) 
      {
    	  
         // logger.info("Fetching employee with ID: {}", id);
          
    	 
          Employee employee = service.findEmployeeById(id);
          
          if (employee == null)
          {
             // logger.error("Employee not found with ID: {}", id);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          
        //  logger.info("Employee found: {}", employee);
          return ResponseEntity.ok(employee);
         }
         
      

      @GetMapping("/search/{name}")
      public ResponseEntity<String> findEmployeeByName(@PathVariable("name") String name)
      {
          String result = service.findByName(name);

          // Check if the result is an error message or a list of names
          if (result.startsWith("No employees found")) 
          {
              return new ResponseEntity<>(result, HttpStatus.NOT_FOUND); // Return 404 if no employees found
          }

          return new ResponseEntity<>(result, HttpStatus.OK);  // Return 200 with names
      }
	  
	
	
}
