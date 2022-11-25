package com.kodlamaio.bootccampproject.business.requests.blacklistRequests;

import com.kodlamaio.bootccampproject.entities.applications.Application;
import com.kodlamaio.bootccampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBlacklistRequest {

    private int applicantId;
    private LocalDate date;
    private String reason;
}
