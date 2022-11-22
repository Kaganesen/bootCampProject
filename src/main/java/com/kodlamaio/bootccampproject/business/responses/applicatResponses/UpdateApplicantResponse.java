package com.kodlamaio.bootccampproject.business.responses.applicatResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateApplicantResponse {

    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String about;
}
