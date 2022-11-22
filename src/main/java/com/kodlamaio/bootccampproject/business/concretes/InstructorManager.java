package com.kodlamaio.bootccampproject.business.concretes;

import com.kodlamaio.bootccampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.DeleteInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.DeleteInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.InstructorRepository;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import com.kodlamaio.bootccampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateInstructorResponse add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);
        this.instructorRepository.save(instructor);
        CreateInstructorResponse  createInstructorResponse = this.modelMapperService.forResponse().map(instructor,CreateInstructorResponse.class);
        return createInstructorResponse;
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);
        this.instructorRepository.save(instructor);
        UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor,UpdateInstructorResponse.class);
        return updateInstructorResponse;
    }

    @Override
    public DeleteInstructorResponse delete(DeleteInstructorRequest deleteInstructorRequest) {
        Instructor instructor = this.instructorRepository.findById(deleteInstructorRequest.getUserId()).get();
        this.instructorRepository.delete(instructor);
        DeleteInstructorResponse deleteInstructorResponse = this.modelMapperService.forResponse().map(instructor,DeleteInstructorResponse.class);
        return deleteInstructorResponse;
    }
}
