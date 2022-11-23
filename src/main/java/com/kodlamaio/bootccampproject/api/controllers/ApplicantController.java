package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.DeleteApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping()
    public DataResult<CreateApplicantResponse> create (CreateApplicantRequest createApplicantRequest) {
        return this.applicantService.add(createApplicantRequest);
    }
    @PutMapping()
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest){
        return this.applicantService.update(updateApplicantRequest);
    }
    @DeleteMapping("/{id}")
    public Result  delete(@PathVariable int id){
        return this.applicantService.delete(id);
    }
    @GetMapping("/{id}")
    public DataResult<GetApplicantResponse> getById(@PathVariable int id){
        return this.applicantService.getById(id);
    }
    @GetMapping()
    public DataResult<List<GetAllApplicantResponse>> getAll(){
        return this.applicantService.getAll();
    }
}