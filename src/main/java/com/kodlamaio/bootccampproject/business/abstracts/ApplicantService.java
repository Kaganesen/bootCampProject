package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicantResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicantService {

    DataResult<CreateApplicantResponse> add (CreateApplicantRequest createApplicantRequest);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
    Result delete (int id );

    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<GetApplicantResponse> getById(int id);

    void checkIfExistByApplicantId(int id)throws BusinessException;

    void checkIfExistByNationalIdentity(String nationalIdentity)throws BusinessException;
}
