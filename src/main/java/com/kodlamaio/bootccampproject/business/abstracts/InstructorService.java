package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.GetAllInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {

    DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);

    DataResult<List<GetAllInstructorResponse>> getAll();

    DataResult<GetInstructorResponse> getById(int id);

    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);

    Result delete(int id);


}
