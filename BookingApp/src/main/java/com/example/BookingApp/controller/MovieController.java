package com.example.BookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingApp.Service.implementation.MovieServiceimpl;
import com.example.BookingApp.dto.EntryDto.MovieEntryDto;
import com.example.BookingApp.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookingApp.dto.ResponseDto.MovieResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("movie")
@Slf4j
public class MovieController {
    @Autowired
    MovieServiceimpl movieService;


    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){

        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);

        log.info("The movieResponseDto is ",movieResponseDto);
        return movieResponseDto;

    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getNameAndId(@PathVariable Integer id){

        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);

        return movieNameAndIdObject;
    }
}
