package com.codeWithAsif.SpringBoot.Controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithAsif.SpringBoot.entity.Department;
import com.codeWithAsif.SpringBoot.service.DepartmentService;



@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger=org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Inside save department of departmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentsList()
	{
		logger.info("Inside get department of departmentController");
		return departmentService.fetchDepartmentsList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId)
	{
		departmentService.deleteDepartmentById(departmentId);
		return "Deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId , @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String name)
	{
		return departmentService.fetchDepartmentByName(name);
	}
	
}
