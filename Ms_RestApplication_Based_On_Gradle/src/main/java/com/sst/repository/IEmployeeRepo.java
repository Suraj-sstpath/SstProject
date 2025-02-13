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
	 
    //Generate The Custom query for find the Between the id 
	 @Query("SELECT o FROM Employee o WHERE o.ids BETWEEN :startId AND :endId")
	 List<Employee> findOrdersByIdRange(@Param("startId") Long startId, @Param("endId") Long endId);
	 
	 @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :startSal AND :endSal")
	 List<Employee> findBalanceAmountBetweenTheRange(@Param("startSal") Double startId, @Param("endSal") Double endId);
	 
	 
}
