package com.mypack.springbootrestreactapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;
	 @Override
	   public List<EmployeeModel> getAllEmployee() {
		  List<EmployeeModel> personModelList = new ArrayList<>();
	      CriteriaQuery<Employee> criteriaQuery = em.getCriteriaBuilder().createQuery(Employee.class);
	      @SuppressWarnings("unused")
	      Root<Employee> root = criteriaQuery.from(Employee.class);
	      List<Employee> list = em.createQuery(criteriaQuery).getResultList(); 
	      if(list != null && !list.isEmpty()) {
	    	  for (Employee person : list) {
	    		  EmployeeModel employeeModel = new EmployeeModel();
	    		  employeeModel.setName(person.getFirstName());
	    		  
	    	      personModelList.add(employeeModel);
	    	  }
	      }
	      return personModelList;
	   }
}
