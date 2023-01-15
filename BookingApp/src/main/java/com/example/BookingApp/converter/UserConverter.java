package com.example.BookingApp.converter;

import com.example.BookingApp.Model.UserEntity;
import com.example.BookingApp.dto.EntryDto.UserEntryDto;
import com.example.BookingApp.dto.ResponseDto.UserResponseDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();


        //Second method for creating the object ??
        //Using the new keyword

    }

    public static UserResponseDto convertEntityToDto(UserEntity user){

        return UserResponseDto.builder().id(user.getId()).name(user.getName())
                .mobNo(user.getMobile()).build();

    }
}
