package com.kodlamaio.bootccampproject.business.requests.applicantRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateApplicantRequest {

    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String about;
}