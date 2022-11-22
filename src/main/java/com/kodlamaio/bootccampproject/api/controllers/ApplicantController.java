package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.DeleteApplicantRequest;
import com.kodlamaio.bootccampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.CreateApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.DeleteApplicantResponse;
import com.kodlamaio.bootccampproject.business.responses.applicatResponses.UpdateApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping("/add")
    public CreateApplicantResponse add(CreateApplicantRequest createApplicantRequest) {
        return this.applicantService.add(createApplicantRequest);
    }
    @PutMapping("/update")
    public UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest){
        return this.applicantService.update(updateApplicantRequest);
    }
    @DeleteMapping("/delete")
    public DeleteApplicantResponse delete(DeleteApplicantRequest deleteApplicantRequest){
        return this.applicantService.delete(deleteApplicantRequest);
    }

}
