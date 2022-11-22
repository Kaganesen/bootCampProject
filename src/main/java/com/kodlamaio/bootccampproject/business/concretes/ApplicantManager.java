package com.kodlamaio.bootccampproject.business.concretes;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.DeleteApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.CreateApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.DeleteApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.UpdateApplicantResponse;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest createApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest , Applicant.class);
        this.applicantRepository.save(applicant);
        CreateApplicantResponse createApplicantResponse = this.modelMapperService.forResponse().map(applicant,CreateApplicantResponse.class);

        return createApplicantResponse;
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
        this.applicantRepository.save(applicant);
        UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,UpdateApplicantResponse.class);

        return updateApplicantResponse;
    }

    @Override
    public DeleteApplicantResponse delete(DeleteApplicantRequest deleteApplicantRequest) {
        Applicant applicant = this.applicantRepository.findById(deleteApplicantRequest.getUserId()).get();
        this.applicantRepository.delete(applicant);
        DeleteApplicantResponse deleteApplicantResponse = this.modelMapperService.forResponse().map(applicant, DeleteApplicantResponse.class);
        return deleteApplicantResponse;
    }


}

