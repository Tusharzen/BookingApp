package com.example.BookingApp.Service;

import com.example.BookingApp.dto.BookTicketRequestDto;
import com.example.BookingApp.dto.ResponseDto.TicketResponseDto;

public interface TicketService {
    
    TicketResponseDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
}
