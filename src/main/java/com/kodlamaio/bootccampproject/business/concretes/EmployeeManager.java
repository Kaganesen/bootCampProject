package com.kodlamaio.bootccampproject.business.concretes;

import com.kodlamaio.bootccampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.DeleteEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import com.kodlamaio.bootccampproject.entities.users.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,CreateEmployeeResponse.class);

        return createEmployeeResponse;
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,UpdateEmployeeResponse.class);

        return updateEmployeeResponse;
    }

    @Override
    public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        Employee employee = this.employeeRepository.findById(deleteEmployeeRequest.getUserId()).get();
        this.employeeRepository.delete(employee);
        DeleteEmployeeResponse deleteEmployeeResponse = this.modelMapperService.forResponse().map(employee,DeleteEmployeeResponse.class);

        return deleteEmployeeResponse ;
    }
}
