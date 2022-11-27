package com.kodlamaio.bootccampproject.business.requests.blacklistRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodlamaio.bootccampproject.entities.applications.Application;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBlacklistRequest {

    @Min(1)
    @NotNull
    private int applicantId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate date;
    @NotNull
    @Min(1)
    private String reason;
}
