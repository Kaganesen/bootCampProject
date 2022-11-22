package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.DeleteApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.CreateApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.DeleteApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.UpdateApplicantResponse;

public interface ApplicantService {

    CreateApplicantResponse add (CreateApplicantRequest createApplicantRequest);
    UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest);
    DeleteApplicantResponse delete (DeleteApplicantRequest deleteApplicantRequest);
}
