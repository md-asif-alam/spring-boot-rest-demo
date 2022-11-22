package com.codeWithAsif.SpringBoot.service;

import java.util.List;

import com.codeWithAsif.SpringBoot.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentsList();

	public Department fetDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String name);

}
