package com.kodlamaio.bootccampproject.business.responses.blacklistResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetBlacklistResponse {

    private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
}
