package com.kodlamaio.bootccampproject.business.responses.instructorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllInstructorResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;

    private LocalDate dateOfBirth;

    private String email;

    private String companyName;


}
