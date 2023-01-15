package com.example.BookingApp.Service;

import com.example.BookingApp.dto.EntryDto.TheaterEntryDto;
import com.example.BookingApp.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {
    
     TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

     TheaterResponseDto getTheater(int id);

}
