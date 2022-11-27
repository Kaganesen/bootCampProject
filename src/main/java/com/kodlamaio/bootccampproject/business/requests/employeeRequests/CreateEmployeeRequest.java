package com.kodlamaio.bootccampproject.business.requests.employeeRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeRequest {

    @NotBlank
    @Size(min = 3)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String position;
    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    private String nationalIdentity;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}
