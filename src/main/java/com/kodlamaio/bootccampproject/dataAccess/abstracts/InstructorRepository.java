package com.kodlamaio.bootccampproject.dataAccess.abstracts;

import com.kodlamaio.bootccampproject.entities.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    boolean existsByNationalIdentity (String nationalIdentity);
    Instructor findById(int id);

}
