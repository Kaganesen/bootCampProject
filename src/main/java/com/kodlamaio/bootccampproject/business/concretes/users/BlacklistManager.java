package com.kodlamaio.bootccampproject.business.concretes.users;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootccampproject.business.abstracts.BlacklistService;
import com.kodlamaio.bootccampproject.business.constants.Messages;
import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.CreateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.UpdateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.CreateBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetAllBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.UpdateBlacklistResponse;
import com.kodlamaio.bootccampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootccampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootccampproject.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.bootccampproject.entities.blacklist.BlackList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

    private BlackListRepository blackListRepository;
    private ModelMapperService modelMapperService;
    private ApplicantService applicantService;
    @Override
    public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest) {
       this.applicantService.checkIfExistByApplicantId(createBlacklistRequest.getApplicantId());
        BlackList blackList = this.modelMapperService.forRequest().map(createBlacklistRequest, BlackList.class);
        this.blackListRepository.save(blackList);
        CreateBlacklistResponse createBlacklistResponse = this.modelMapperService.forResponse().map(blackList, CreateBlacklistResponse.class);

        return new SuccessDataResult<>(createBlacklistResponse,Messages.BlacklistAdded);
    }

    @Override
    public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest) {
        this.applicantService.checkIfExistByApplicantId(updateBlacklistRequest.getApplicantId());
        BlackList blackList = this.modelMapperService.forRequest().map(updateBlacklistRequest, BlackList.class);
        this.blackListRepository.save(blackList);
        UpdateBlacklistResponse updateBlacklistResponse = this.modelMapperService.forResponse().map(blackList, UpdateBlacklistResponse.class);

        return new SuccessDataResult<>(updateBlacklistResponse,Messages.DataUpdated);
    }

    @Override
    public DataResult<GetBlacklistResponse> getById(int id) {
        checkIfExistsByBlacklistId(id);
        BlackList blackList = this.blackListRepository.findById(id).orElse(null);
        GetBlacklistResponse getBlacklistResponse = this.modelMapperService.forResponse().map(blackList, GetBlacklistResponse.class);

        return new SuccessDataResult<>(getBlacklistResponse,Messages.DataListed);
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAll() {
        List<BlackList> blackLists = this.blackListRepository.findAll();
        List<GetAllBlacklistResponse> getAllBlacklistResponses = blackLists.stream().map(blackList -> this.modelMapperService.forResponse().map(blackList, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(getAllBlacklistResponses,Messages.DataListed);
    }

    @Override
    public Result delete(int id) {
        checkIfExistsByBlacklistId(id);
        this.blackListRepository.deleteById(id);

        return new SuccessResult(Messages.DataDeleted);
    }

    public void checkIfExistsByBlacklistId(int id) {

        if (!this.blackListRepository.existsById(id)) {
            throw new BusinessException(Messages.BlacklistNotFound + id);

        }
    }
    public void checkIfNotExistsByApplicantId(int id){
        if (this.blackListRepository.existsByApplicantId(id)){
            throw new BusinessException(Messages.BlacklistIdAlreadyExists + id + id);
        }
    }


}
