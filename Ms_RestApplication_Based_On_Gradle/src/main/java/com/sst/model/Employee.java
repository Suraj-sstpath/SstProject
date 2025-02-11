package com.sst.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee
{
	
	@Id
	@SequenceGenerator(name ="gen1",sequenceName ="Employee_id",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer ids;
	@Schema(description = "Name of the user",example ="Alok")
	private String names;
	@Schema(description = "Name of the department",example ="Developer")
	private String department;
	@Schema(description = "Employee Salary Based on the department ",example ="656556.555")
	private double salary;
	
	
	

}
