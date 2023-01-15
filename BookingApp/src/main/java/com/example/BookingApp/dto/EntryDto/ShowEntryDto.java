package com.example.BookingApp.dto.EntryDto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.sun.istack.NotNull;

import lombok.Data;

import com.example.BookingApp.dto.ResponseDto.MovieResponseDto;
import com.example.BookingApp.dto.ResponseDto.TheaterResponseDto;

@Data
public class ShowEntryDto {
    
    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheaterResponseDto theaterResponseDto;
}
