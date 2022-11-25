package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.UpdateApplicationRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.CreateApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.UpdateApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetAllApplicationsResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {

    DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

    Result delete(int id);

    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);

    DataResult<GetApplicationResponse> getById(int id);

    DataResult<List<GetAllApplicationsResponse>> getAll();
}
