package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {

    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
    Result delete(int id);
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> getById(int id);

}
