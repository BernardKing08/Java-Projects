package com.realestate.realestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.model.HouseInfo;
import com.realestate.realestate.repository.HouseInfoRepository;

@Service
public class HouseInfoService {
    
    @Autowired
    private HouseInfoRepository houseInfoRepository;

    public List<HouseInfo> getAllHouses() {
        return houseInfoRepository.findAll();
    }

    public HouseInfo getHouseById(Integer id) {
        return houseInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found with ID: " + id));
    }
}
