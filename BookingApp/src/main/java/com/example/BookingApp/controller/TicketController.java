package com.example.BookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingApp.Service.implementation.TicketServiceimpl;
import com.example.BookingApp.dto.BookTicketRequestDto;
import com.example.BookingApp.dto.ResponseDto.TicketResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("ticket")
public class TicketController {
    
    @Autowired
    TicketServiceimpl ticketService;

    @GetMapping("get/{id}")
    public TicketResponseDto getTicketById(@PathVariable Integer id){

        return ticketService.getTicket(id);
    }

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){


        log.info("In controller");
        return ticketService.bookTicket(bookTicketRequestDto);

    }
}
