package com.kodlamaio.bootccampproject.business.responses.bootcampResponses;

import com.kodlamaio.bootccampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllBootcampResponse {

    private int id;

    private String name;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private int state;

    private int instructorId;


}
