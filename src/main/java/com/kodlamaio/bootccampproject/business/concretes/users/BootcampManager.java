package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.BootcampService;
import com.kodlamaio.bootccampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.BootCampRepository;
import com.kodlamaio.bootccampproject.entities.bootcamps.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {

    private BootCampRepository bootcampRepository;
    private ModelMapperService modelMapperService;

    private InstructorService instructorService;

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
        this.instructorService.checkIfExistsByInstructorId(createBootcampRequest.getInstructorId());
        checkIfFirstDateBeforeSecondDate(createBootcampRequest.getDateStart(),createBootcampRequest.getDateEnd());
        Bootcamp bootCamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
        bootCamp.setId(0);
        this.bootcampRepository.save(bootCamp);
        CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootCamp, CreateBootcampResponse.class);
        return new SuccessDataResult<>(createBootcampResponse, Messages.DataListed);
    }

    @Override
    public Result delete(int id) {
        this.bootcampRepository.deleteById(id);
        return new SuccessResult(Messages.DataDeleted);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        this.instructorService.checkIfExistsByInstructorId(updateBootcampRequest.getInstructorId());
        checkIfFirstDateBeforeSecondDate(updateBootcampRequest.getDateStart(),updateBootcampRequest.getDateEnd());
        Bootcamp bootCamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        this.bootcampRepository.save(bootCamp);
        UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootCamp, UpdateBootcampResponse.class);
        return new SuccessDataResult<>(updateBootcampResponse, Messages.DataUpdated);
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootCamps = this.bootcampRepository.findAll();
        List<GetAllBootcampResponse> getAllBootcampResponses = bootCamps.stream().map(bootCamp -> this.modelMapperService.forResponse().map(bootCamp, GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(getAllBootcampResponses, Messages.DataListed);
    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        checkIfExistsByBootcampId(id);
        Bootcamp bootCamp = this.bootcampRepository.findById(id).get();
        GetBootcampResponse getBootcampResponse = this.modelMapperService.forResponse().map(bootCamp, GetBootcampResponse.class);

        return new SuccessDataResult<>(getBootcampResponse, Messages.DataListed);
    }

    public void checkIfExistsByBootcampId(int id) throws BusinessException {
        if (!this.bootcampRepository.existsById(id)) {
            throw new BusinessException(Messages.BootcampIdNotFound + id);
        }
    }
    private void checkIfFirstDateBeforeSecondDate(LocalDate dateStart , LocalDate dateEnd){
        if (dateEnd.isBefore(dateStart) || dateStart.equals(dateEnd)){
            throw new BusinessException(Messages.FinishDateCannotBeforeStartDate);
        }
    }

}
