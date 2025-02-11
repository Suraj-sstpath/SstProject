package com.sst.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sst.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer>
{
	//Generate The Custom query for find the name
	 @Query("SELECT e FROM Employee e WHERE e.names = :names")
	 Optional<Employee> findByName(@Param("names") String name);

}
