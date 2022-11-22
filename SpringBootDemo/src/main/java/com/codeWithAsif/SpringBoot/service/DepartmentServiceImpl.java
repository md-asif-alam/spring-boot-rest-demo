package com.codeWithAsif.SpringBoot.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithAsif.SpringBoot.entity.Department;
import com.codeWithAsif.SpringBoot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentsList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department fetDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department depDb=departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
			depDb.setDepartmentName(department.getDepartmentName());
		
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
			depDb.setDepartmentCode(department.getDepartmentCode());
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
			depDb.setDepartmentAddress(department.getDepartmentAddress());
		
		return departmentRepository.save(depDb);
	}

	@Override
	public Department fetchDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}

}
