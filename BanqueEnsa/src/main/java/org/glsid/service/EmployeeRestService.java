package org.glsid.service;

import java.util.List;

import org.glsid.entities.Employee;
import org.glsid.metier.EmployeeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestService {
	@Autowired
	private EmployeeMetier employeeMetier;

	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public Employee saveemploye(@RequestBody Employee e) {
		return employeeMetier.saveemploye(e);
	}
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	public List<Employee> listemploye() {
		return employeeMetier.listemploye();
	}

}
