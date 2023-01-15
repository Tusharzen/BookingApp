package com.example.BookingApp.converter;

import com.example.BookingApp.Model.TicketEntity;
import com.example.BookingApp.dto.ResponseDto.TicketResponseDto;

public class TicketConverter {
    
    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllotedSeat())
                .build();

    }
}
