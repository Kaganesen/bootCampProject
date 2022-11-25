package com.kodlamaio.bootccampproject.business.requests.applicationRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateApplicationRequest {

    private int applicantId;
    private int bootcampId;
    private int state;




}
