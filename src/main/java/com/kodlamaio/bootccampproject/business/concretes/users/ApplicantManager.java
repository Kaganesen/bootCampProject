package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
        checkIfApplicantByNationalId(createApplicantRequest.getNationalIdentity());
        Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest,Applicant.class);
        this.applicantRepository.save(applicant);
        CreateApplicantResponse createApplicantResponse = this.modelMapperService.forResponse().map(applicant,CreateApplicantResponse.class);

        return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse,Messages.DataAdded);
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
        checkIfApplicantById(updateApplicantRequest.getId());
        Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
        this.applicantRepository.save(applicant);
        UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse,Messages.DataUpdated) ;
    }

    @Override
    public Result delete(int id) {
        checkIfApplicantById(id);
        this.applicantRepository.deleteById(id);
        return new SuccessResult(Messages.DataDeleted);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = this.applicantRepository.findAll();
        List<GetAllApplicantResponse> getAllApplicantResponses = applicants.stream().map(applicant -> this.modelMapperService.forResponse().map(applicant,GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>(getAllApplicantResponses,Messages.DataListed);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        checkIfApplicantById(id);
        Applicant applicant = this.applicantRepository.findById(id).get();
        GetApplicantResponse getApplicantResponse = this.modelMapperService.forResponse().map(applicant,GetApplicantResponse.class);

        return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse,Messages.DataListed);
    }

    private void checkIfApplicantByNationalId(String nationalIdentity){
        if (this.applicantRepository.existsByNationalIdentity(nationalIdentity)){
            throw new BusinessException(Messages.ExistByid);
        }
    }

    private void checkIfApplicantById(int id){
        Applicant applicant = this.applicantRepository.findById(id).orElse(null);
        if (applicant == null){
            throw new BusinessException(Messages.ApplicantExists);
        }
    }

}

