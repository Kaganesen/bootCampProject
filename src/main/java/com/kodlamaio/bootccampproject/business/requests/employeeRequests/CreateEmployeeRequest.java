package com.kodlamaio.bootccampproject.business.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String position;
}
