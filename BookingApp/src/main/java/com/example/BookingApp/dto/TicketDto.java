package com.example.BookingApp.dto;

import com.example.BookingApp.dto.ResponseDto.ShowResponseDto;
import com.example.BookingApp.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {
    
    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto; //Mandatory for me to fill this userDto Value
}
