package com.kodlamaio.bootccampproject.business.abstracts;

import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.CreateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.UpdateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.CreateBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetAllBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.UpdateBlacklistResponse;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;

import java.util.List;

public interface BlacklistService {

    DataResult<CreateBlacklistResponse> add (CreateBlacklistRequest createBlacklistRequest);
    DataResult<UpdateBlacklistResponse> update (UpdateBlacklistRequest updateBlacklistRequest);
    DataResult<GetBlacklistResponse> getById (int id);
    DataResult<List<GetAllBlacklistResponse>> getAll();
    Result delete (int id);
}
