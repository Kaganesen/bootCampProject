package com.kodlamaio.bootccampproject.business.responses.instructorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInstructorResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;

    private LocalDate dateOfBirth;

    private String email;

    private String companyName;

}
