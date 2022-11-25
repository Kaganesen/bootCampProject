package com.kodlamaio.bootccampproject.dataAccess.abstracts;

import com.kodlamaio.bootccampproject.entities.users.Employee;
import com.kodlamaio.bootccampproject.entities.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    boolean existsByNationalIdentity (String nationalIdentity);

}
