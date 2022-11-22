package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.DeleteInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.DeleteInstructorResponse;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.UpdateInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;

    @PostMapping("/add")
    public CreateInstructorResponse add(CreateInstructorRequest createInstructorRequest){
        return this.instructorService.add(createInstructorRequest);
    }

    @PutMapping("/update")
    public UpdateInstructorResponse update (UpdateInstructorRequest updateInstructorRequest){
        return this.instructorService.update(updateInstructorRequest);
    }

    @DeleteMapping("/delete")
    public DeleteInstructorResponse delete (DeleteInstructorRequest deleteInstructorRequest){
        return this.instructorService.delete(deleteInstructorRequest);
    }


}
