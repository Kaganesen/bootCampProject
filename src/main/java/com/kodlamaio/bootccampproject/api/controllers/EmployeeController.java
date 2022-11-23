package com.kodlamaio.bootccampproject.api.controllers;


import com.kodlamaio.bootccampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

     private EmployeeService employeeService;

     @GetMapping("/{id}")
    public DataResult<GetEmployeeResponse> getById(@PathVariable int id){
         return this.employeeService.getById(id);
     }
     @GetMapping()
    public DataResult<List<GetAllEmployeeResponse>> getAll(){
         return this.employeeService.getAll();
     }
     @PostMapping()
    public DataResult<CreateEmployeeResponse> create(@RequestBody CreateEmployeeRequest createEmployeeRequest){
         return this.employeeService.add(createEmployeeRequest);
     }
     @PutMapping()
    public  DataResult<UpdateEmployeeResponse> update (@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
         return this.employeeService.update(updateEmployeeRequest);
     }
     @DeleteMapping("/{id}")
    public Result delete (@PathVariable int id){
         return this.employeeService.delete(id);
     }



}
