package com.kodlamaio.bootccampproject.entities.users;

import com.kodlamaio.bootccampproject.entities.bootcamps.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructors")
public class Instructor extends User {

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootCamps;


}
