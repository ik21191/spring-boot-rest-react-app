package com.mypack.springbootrestreactapp;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	@Override
	public List<EmployeeModel> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
}
