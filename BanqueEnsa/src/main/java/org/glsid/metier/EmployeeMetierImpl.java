package org.glsid.metier;

import java.util.List;

import org.glsid.dao.EmployeeRepository;
import org.glsid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeMetierImpl implements EmployeeMetier{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveemploye(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> listemploye() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
