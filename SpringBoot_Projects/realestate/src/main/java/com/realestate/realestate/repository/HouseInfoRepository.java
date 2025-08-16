package com.realestate.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.realestate.model.HouseInfo;

@Repository
public interface HouseInfoRepository extends JpaRepository<HouseInfo, Integer>  {
    
}
