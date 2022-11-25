package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicationService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.UpdateApplicationRequest;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetAllApplicationsResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.bootccampproject.entities.applications.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationManager implements ApplicationService {


    private ApplicationRepository applicationRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
        Application application = this.modelMapperService.forRequest().map(createApplicationRequest, Application.class);
        this.applicationRepository.save(application);
        CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<>(createApplicationResponse, Messages.DataAdded);
    }

    @Override
    public Result delete(int id) {
        checkIfApplicationByid(id);
        this.applicationRepository.deleteById(id);
        return new SuccessResult(Messages.DataDeleted);
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
        checkIfApplicationByid(updateApplicationRequest.getId());
        Application application = this.modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
        this.applicationRepository.save(application);
        UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);

        return new SuccessDataResult<>(updateApplicationResponse, Messages.DataUpdated);
    }

    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        checkIfApplicationByid(id);
        Application application = this.applicationRepository.findById(id).get();
        GetApplicationResponse getApplicationResponse = this.modelMapperService.forResponse().map(application, GetApplicationResponse.class);

        return new SuccessDataResult<>(getApplicationResponse, Messages.DataListed);
    }

    @Override
    public DataResult<List<GetAllApplicationsResponse>> getAll() {
        List<Application> applications = this.applicationRepository.findAll();
        List<GetAllApplicationsResponse> getAllApplicationsResponses = applications.stream().map(application -> this.modelMapperService.forResponse().map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllApplicationsResponses, Messages.DataListed);
    }

    private void checkIfApplicationByid(int id) {
        Application application = this.applicationRepository.findById(id).orElse(null);
        if (application == null) {
            throw new BusinessException(Messages.ApplicationExists);
        }
    }

}
