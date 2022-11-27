package com.kodlamaio.bootccampproject.business.requests.applicationRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateApplicationRequest {

    @Min(1)
    @NotNull
    private int applicantId;
    @Min(1)
    @NotNull
    private int bootcampId;
    @NotNull
    private int state;


}
