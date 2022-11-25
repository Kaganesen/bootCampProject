package com.kodlamaio.bootccampproject.dataAccess.abstracts;

import com.kodlamaio.bootccampproject.entities.applications.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
