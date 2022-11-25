package com.kodlamaio.bootccampproject.business.responses.bootcampResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateBootcampResponse {

    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int state;
    private int instructorId;
}
