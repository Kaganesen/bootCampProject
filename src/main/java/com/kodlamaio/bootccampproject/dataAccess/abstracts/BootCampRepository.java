package com.kodlamaio.bootccampproject.dataAccess.abstracts;

import com.kodlamaio.bootccampproject.entities.bootcamps.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootCampRepository extends JpaRepository<Bootcamp,Integer> {

}
