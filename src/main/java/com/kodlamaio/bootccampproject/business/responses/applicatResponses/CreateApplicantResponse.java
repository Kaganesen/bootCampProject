package com.kodlamaio.bootccampproject.business.responses.applicatResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateApplicantResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String about;
}
