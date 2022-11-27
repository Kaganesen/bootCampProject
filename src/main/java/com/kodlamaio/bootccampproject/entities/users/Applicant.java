package com.kodlamaio.bootccampproject.entities.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
public class Applicant extends User {


    @Column(name = "about")
    private String about;


}
