package com.kodlamaio.bootccampproject.business.requests.applicationRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateApplicationRequest {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int state;


}
