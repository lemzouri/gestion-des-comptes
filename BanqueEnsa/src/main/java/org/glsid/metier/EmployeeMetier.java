package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Employee;

public interface EmployeeMetier {

	public Employee saveemploye(Employee e);
	public List<Employee> listemploye();
	
}
