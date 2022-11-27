package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicationService;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootccampproject.business.requests.applicationRequests.UpdateApplicationRequest;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetAllApplicationsResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.GetApplicationResponse;
import com.kodlamaio.bootccampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applications")
public class ApplicationController {

    private ApplicationService applicationService;

    @PostMapping
    DataResult<CreateApplicationResponse> create (@Valid @RequestBody CreateApplicationRequest createApplicationRequest){
        return this.applicationService.add(createApplicationRequest);
    }
    @PutMapping
    DataResult<UpdateApplicationResponse> update (@Valid @RequestBody UpdateApplicationRequest updateApplicationRequest){
        return this.applicationService.update(updateApplicationRequest);
    }

    @GetMapping
    DataResult<List<GetAllApplicationsResponse>> getAll (){
        return this.applicationService.getAll();
    }

    @GetMapping("/{id}")
    DataResult<GetApplicationResponse> getById (@PathVariable int id){
        return this.applicationService.getById(id);
    }

    @DeleteMapping("/{id}")
    Result delete (@PathVariable int id){
        return this.applicationService.delete(id);
    }

}
