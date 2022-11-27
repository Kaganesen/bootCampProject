package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface BootcampService {

    DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);

    Result delete (int id);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);
    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);

    void checkIfExistsByBootcampId(int id) throws BusinessException;

}
