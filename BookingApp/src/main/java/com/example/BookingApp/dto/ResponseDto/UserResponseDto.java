package com.example.BookingApp.dto.ResponseDto;

import java.util.List;

import com.example.BookingApp.dto.TicketDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    
    int id;

    String name;

    String mobNo;

    //Optional
    List<TicketDto> tickets;
}
