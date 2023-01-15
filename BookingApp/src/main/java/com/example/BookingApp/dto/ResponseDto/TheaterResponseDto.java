package com.example.BookingApp.dto.ResponseDto;

import com.example.BookingApp.enums.TheaterType;

import lombok.Builder;
import lombok.Data;
import com.sun.istack.NotNull;

@Data
@Builder
public class TheaterResponseDto {
    
    @NotNull
    int id;

    String name;
    String address;
    String city;
    TheaterType type;
}
