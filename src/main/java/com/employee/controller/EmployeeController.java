package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	
	public String viewHomePage(Model model)
	{
		model.addAttribute("allemplist", employeeService.getAllEmployees());
		return "index";
	}
	
	
	@GetMapping("/add")
	public String addEmployee(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("updateform/{id}")
	public String updateForm(@PathVariable("id") long id,Model model)
	{
		Employee employee=employeeService.getById(id);
		model.addAttribute("employee", employee);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String dleteById(@PathVariable("id")long id)
	{
		employeeService.deleteById(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
}
