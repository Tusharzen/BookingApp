package com.example.BookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingApp.Service.implementation.ShowServiceimpl;
import com.example.BookingApp.dto.EntryDto.ShowEntryDto;
import com.example.BookingApp.dto.ResponseDto.ShowResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("show")
public class ShowController {
    
    @Autowired
    ShowServiceimpl showService;


    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){

        log.info("Here we are");

        return showService.addShow(showEntryDto);
    }
}
