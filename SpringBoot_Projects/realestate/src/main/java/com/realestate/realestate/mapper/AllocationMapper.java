package com.realestate.realestate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.realestate.realestate.dto.AdminAllocationDTO;
import com.realestate.realestate.model.Allocation;

@Mapper(componentModel = "spring")
public interface AllocationMapper {

    AllocationMapper INSTANCE = Mappers.getMapper(AllocationMapper.class);

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "person.name", target = "name")
    @Mapping(source = "room.roomNo", target = "roomNo")
    @Mapping(source = "room.house.location", target = "houseAddress")
    @Mapping(source = "person.entryDate", target = "dateApplied")
    @Mapping(source = "status", target = "accommodationStatus")
    AdminAllocationDTO toDTO(Allocation allocation);
}
