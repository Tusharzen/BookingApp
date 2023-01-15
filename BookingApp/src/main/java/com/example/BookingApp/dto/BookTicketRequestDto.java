package com.example.BookingApp.dto;

import java.util.Set;

import com.example.BookingApp.enums.SeatType;

import lombok.Data;

@Data
public class BookTicketRequestDto {
    
    int id; // user id
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
