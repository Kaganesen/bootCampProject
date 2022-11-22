package com.kodlamaio.bootccampproject.api.controllers;


import com.kodlamaio.bootccampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.DeleteEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

     private EmployeeService employeeService;


     @PostMapping("/add")
    public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest){
        return this.employeeService.add(createEmployeeRequest);
    }

    @PutMapping("/update")
    public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest){
         return this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest){
         return this.employeeService.delete(deleteEmployeeRequest);
    }
}
