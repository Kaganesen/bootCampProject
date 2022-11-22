package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.DeleteInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.DeleteInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.UpdateInstructorResponse;

public interface InstructorService {

    CreateInstructorResponse add(CreateInstructorRequest createInstructorRequest);
    UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest);
    DeleteInstructorResponse delete(DeleteInstructorRequest deleteInstructorRequest);

}
