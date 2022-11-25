package com.kodlamaio.bootccampproject.entities.bootcamps;

import com.kodlamaio.bootccampproject.entities.applications.Application;
import com.kodlamaio.bootccampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamps")

public class Bootcamp {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Instructor instructor;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;


}

