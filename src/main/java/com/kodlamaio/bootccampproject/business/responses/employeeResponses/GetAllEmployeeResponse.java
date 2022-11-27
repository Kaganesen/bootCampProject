package com.kodlamaio.bootccampproject.business.responses.employeeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String nationalIdentity;
    private LocalDate dateOfBirth;
}
