package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.GetAllEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootccampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.bootccampproject.entities.users.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        checkIfEmployeeByNationalId(createEmployeeRequest.getNationalIdentity());
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.DataAdded);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        checkIfEmployeeById(updateEmployeeRequest.getId());
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
        UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse, Messages.DataUpdated);
    }

    @Override
    public Result delete(int id) {
        checkIfEmployeeById(id);
        this.employeeRepository.deleteById(id);
        return new SuccessResult(Messages.DataDeleted);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream().map(employee -> this.modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllEmployeeResponse>>(getAllEmployeeResponses,Messages.DataListed);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        checkIfEmployeeById(id);
        Employee employee = this.employeeRepository.findById(id).get();
        GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forResponse().map(employee,GetEmployeeResponse.class);

        return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse,Messages.DataListed);
    }

    private void checkIfEmployeeByNationalId(String nationalIdentity){
        if(this.employeeRepository.existsByNationalIdentity(nationalIdentity)){
            throw new BusinessException(Messages.ExistByid);
        }
    }

    private void checkIfEmployeeById(int id){
       Employee employee = this.employeeRepository.findById(id).orElse(null);
        if (employee == null){
            throw new BusinessException(Messages.EmployeeNoExists);
        }
    }
}
