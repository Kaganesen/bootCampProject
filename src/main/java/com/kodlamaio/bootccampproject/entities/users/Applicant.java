package com.kodlamaio.bootccampproject.entities.users;

import com.kodlamaio.bootccampproject.entities.applications.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
public class Applicant extends User {


    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;

   

}
