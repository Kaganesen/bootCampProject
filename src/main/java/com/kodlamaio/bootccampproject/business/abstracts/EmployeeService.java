package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.DeleteEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.UpdateEmployeeResponse;

public interface EmployeeService {

    CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);
    UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);
    DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest);

}
