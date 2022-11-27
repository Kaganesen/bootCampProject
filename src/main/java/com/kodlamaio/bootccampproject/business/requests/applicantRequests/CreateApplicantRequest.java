package com.kodlamaio.bootccampproject.business.requests.applicantRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateApplicantRequest {
    @NotBlank
    @Size(min = 3)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String about;
    @Size(min = 11, max = 11)
    private String nationalIdentity;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}
