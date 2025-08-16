package com.realestate.realestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.model.Room;
import com.realestate.realestate.repository.RoomRepository;


@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRoomsWithHouse() {
        return roomRepository.findAllWithHouse();
    }
}
