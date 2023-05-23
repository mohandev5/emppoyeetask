package com.task.employeeSystem.service;

import com.task.employeeSystem.entity.Employee;
import com.task.employeeSystem.entity.LoginDetails;
import com.task.employeeSystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepo employeeRepo;

    public Page<Employee>getAllDetails(int pageNumber,int pageSize,String sortAttribute){
        Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortAttribute));
        return  employeeRepo.findAll(pageable);
    }
    public List<Employee>getDetailsByName(String employeeName){
        var nameDetails=  employeeRepo.findEmployeeByEmployeeName(employeeName);
        if(nameDetails.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "you entered wrong name");
        }
        else {
            return nameDetails;
        }
    }



//    public List<Employee> countWorkingHours(String employeeName) {
//        List<Employee> employees = employeeRepo.findEmployeeByEmployeeName(employeeName);

//        for (Employee employee : employees) {
//            if (employee.getRole().equalsIgnoreCase("manager")) {
//                List<LoginDetails> loginDetails = employee.getLoginDetails();
//                Duration totalWorkingHours = Duration.ZERO;

//                for (LoginDetails loginDetail : loginDetails) {
//                    Duration workingHours = Duration.between(loginDetail.getLogin().toLocalTime(), loginDetail.getLogout().toLocalTime());
//                    totalWorkingHours = totalWorkingHours.plus(workingHours);
//                }

//                System.out.println("Total working hours for " + employee.getEmployeeName() + ": " + totalWorkingHours);
//            }
//        }

//        return employees;
//    }

}
