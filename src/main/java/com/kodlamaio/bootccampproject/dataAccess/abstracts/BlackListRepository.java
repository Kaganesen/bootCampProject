package com.kodlamaio.bootccampproject.dataAccess.abstracts;

import com.kodlamaio.bootccampproject.entities.blacklist.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList,Integer> {

}
