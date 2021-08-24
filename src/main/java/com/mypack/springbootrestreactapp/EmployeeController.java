package com.mypack.springbootrestreactapp;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.spring.rest.error.EntityNotFoundException;




@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/api/employees")
    public List <Employee> getAllEmployees() {
		log.info("getAllEmployees method is called.");
        return employeeRepository.findAll();
    }
	
	@PutMapping("/api/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
		log.info("createEmployee method is called.");
        return employeeRepository.save(employee);
    }
	
	@GetMapping("/api/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
    throws Exception {
		log.info("getEmployeeById method is called.");
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new EntityNotFoundException(employeeId.intValue()));
        return ResponseEntity.ok().body(employee);
    }
	
	@DeleteMapping("/api/employees/{id}")
    public ResponseEntity <Object> deleteEmployeeById(@PathVariable(value = "id") Long employeeId)
    throws Exception {
		log.info("deleteEmployeeById method is called.");
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return ResponseEntity.ok().body("Deleted");
		} else {
			throw new EntityNotFoundException(employeeId.intValue());
			
		}
	}
}
