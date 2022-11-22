package com.kodlamaio.bootccampproject.business.responses.employeeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteEmployeeResponse {

    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String position;
}
