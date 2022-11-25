package com.kodlamaio.bootccampproject.business.requests.blacklistRequests;

import com.kodlamaio.bootccampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {

    private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
}
