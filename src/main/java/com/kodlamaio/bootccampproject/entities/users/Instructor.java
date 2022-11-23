package com.kodlamaio.bootccampproject.entities.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructors")
public class Instructor extends User {

    @Column(name = "company_name")
    private String companyName;


}
