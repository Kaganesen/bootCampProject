package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.BlacklistService;
import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.CreateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.requests.blacklistRequests.UpdateBlacklistRequest;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.CreateBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetAllBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.GetBlacklistResponse;
import com.kodlamaio.bootccampproject.business.responses.blacklistResponses.UpdateBlacklistResponse;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blacklists")
public class BlacklistController {

    private BlacklistService blacklistService;


    @PostMapping
    DataResult<CreateBlacklistResponse> create (@Valid @RequestBody CreateBlacklistRequest createBlacklistRequest){
        return this.blacklistService.add(createBlacklistRequest);

    }
    @PutMapping
    DataResult<UpdateBlacklistResponse> update (@Valid @RequestBody UpdateBlacklistRequest updateBlacklistRequest){
        return this.blacklistService.update(updateBlacklistRequest);

    }
    @GetMapping("/{id}")
    DataResult<GetBlacklistResponse> getById (@PathVariable int id){
        return this.blacklistService.getById(id);

    }
    @GetMapping
    DataResult<List<GetAllBlacklistResponse>> getAll(){
        return this.blacklistService.getAll();

    }
    @DeleteMapping("/{id}")
    Result delete (@PathVariable  int id){
        return this.blacklistService.delete(id);
    }
}
