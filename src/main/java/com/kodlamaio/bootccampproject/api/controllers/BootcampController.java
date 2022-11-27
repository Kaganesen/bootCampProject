package com.kodlamaio.bootccampproject.api.controllers;

import com.kodlamaio.bootccampproject.business.abstracts.BootcampService;
import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootccampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootccampproject.business.responses.bootcampResponses.*;
import com.kodlamaio.bootccampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootccampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bootcamps")
public class BootcampController {

    private BootcampService bootcampService;

    @PostMapping
    DataResult<CreateBootcampResponse> create(@Valid @RequestBody CreateBootcampRequest createBootcampRequest) {
        return this.bootcampService.add(createBootcampRequest);
    }
    @GetMapping
    DataResult<List<GetAllBootcampResponse>> getAll (){
        return this.bootcampService.getAll();
    }
    @PutMapping
    DataResult<UpdateBootcampResponse> update (@Valid @RequestBody UpdateBootcampRequest updateBootcampRequest){
        return this.bootcampService.update(updateBootcampRequest);
    }
    @GetMapping("/{id}")
    DataResult<GetBootcampResponse> getById (@PathVariable int id){
        return this.bootcampService.getById(id);
    }
    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id){
        return this.bootcampService.delete(id);
    }

}
