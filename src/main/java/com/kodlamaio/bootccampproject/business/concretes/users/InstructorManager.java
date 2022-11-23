package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.GetAllInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.InstructorRepository;
import com.kodlamaio.bootccampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
        this.instructorRepository.save(instructor);
        CreateInstructorResponse createInstructorResponse = this.modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.DataAdded);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = this.instructorRepository.findAll();
        List<GetAllInstructorResponse> response = instructors
                .stream()
                .map(instructor -> this.modelMapperService
                        .forResponse()
                        .map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorResponse>>(response, Messages.DataListed);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor = this.instructorRepository.findById(id).get();
        GetInstructorResponse getInstructorResponse = this.modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);

        return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse,Messages.DataListed);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
        this.instructorRepository.save(instructor);
        UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
        return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.DataUpdated);
    }

    @Override
    public Result delete(int id) {
        this.instructorRepository.deleteById(id);
        return new SuccessResult(Messages.DataDeleted);

    }
}
