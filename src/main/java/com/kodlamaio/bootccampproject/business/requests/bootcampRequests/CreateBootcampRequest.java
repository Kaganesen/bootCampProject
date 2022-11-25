package com.kodlamaio.bootccampproject.business.requests.bootcampRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateBootcampRequest {

    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int state;
    private int instructorId;

}
