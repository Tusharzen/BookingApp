package com.example.BookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingApp.Service.implementation.TheaterServiceimpl;
import com.example.BookingApp.dto.EntryDto.TheaterEntryDto;
import com.example.BookingApp.dto.ResponseDto.TheaterResponseDto;

@RestController
@RequestMapping("theater")
public class TheaterController {
    
    @Autowired
    TheaterServiceimpl theaterService;


    @PostMapping("/add")
    public TheaterResponseDto addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){

        return theaterService.addTheater(theaterEntryDto);

    }
}
