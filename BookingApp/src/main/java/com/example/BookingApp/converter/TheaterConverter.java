package com.example.BookingApp.converter;

import com.example.BookingApp.Model.TheaterEntity;
import com.example.BookingApp.dto.EntryDto.TheaterEntryDto;
import com.example.BookingApp.dto.ResponseDto.TheaterResponseDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).build();


    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){

        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getTheaterType())
                .build();
    }
    
}
