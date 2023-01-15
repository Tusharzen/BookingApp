package com.example.BookingApp.Service;

import com.example.BookingApp.dto.EntryDto.MovieEntryDto;
import com.example.BookingApp.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookingApp.dto.ResponseDto.MovieResponseDto;

public interface MovieService {
    
    //add
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);

}
