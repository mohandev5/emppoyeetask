package com.task.employeeSystem.controller;

import com.task.employeeSystem.entity.Employee;
import com.task.employeeSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{pageNumber}/{pageSize}/{sortAttribute}")
    public Page<Employee> dispalyAll(@PathVariable("pageNumber") int pageNumber,@PathVariable("pageSize") int pageSize,@PathVariable("sortAttribute") String sortAttribute){
        return employeeService.getAllDetails(pageNumber,pageSize,sortAttribute);
    }

    @GetMapping("/employeedetails/{employeeName}")
    public List<Employee>displayemployeesByName(@PathVariable ("employeeName") String employeeName){
        return employeeService.getDetailsByName(employeeName);
    }
//  @GetMapping("/calaculation/{employeeName}")
//    public List<Employee>counting(@PathVariable ("employeeName") String employeeName){
//        return employeeService.countWorkingHours(employeeName);
//  }

}
