package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.DeleteInstructorRequest;
import com.kodlamaio.bootccampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootccampproject.business.responses.instructorResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;

    @GetMapping("/{id}")
    public DataResult<GetInstructorResponse> getById(@PathVariable int id){
        return this.instructorService.getById(id);
    }

    @GetMapping()
    public DataResult<List<GetAllInstructorResponse>> getAll(){
        return this.instructorService.getAll();
    }

    @PostMapping()
    public DataResult<CreateInstructorResponse> create(@Valid @RequestBody CreateInstructorRequest createInstructorRequest){
        return this.instructorService.add(createInstructorRequest);
    }

    @PutMapping()
    public DataResult<UpdateInstructorResponse> update(@Valid @RequestBody UpdateInstructorRequest updateInstructorRequest){
        return this.instructorService.update(updateInstructorRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete (@PathVariable int id){
        return this.instructorService.delete(id);
    }


    /*

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
*/

}
