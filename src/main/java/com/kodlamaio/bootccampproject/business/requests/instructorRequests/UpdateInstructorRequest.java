package com.kodlamaio.bootccampproject.business.requests.instructorRequests;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateInstructorRequest {

    @NotNull
    private int id;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2)
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String companyName;

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    private String nationalIdentity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dateOfBirth;


}
