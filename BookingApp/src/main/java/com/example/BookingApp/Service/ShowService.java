package com.example.BookingApp.Service;

import com.example.BookingApp.dto.EntryDto.ShowEntryDto;
import com.example.BookingApp.dto.ResponseDto.ShowResponseDto;

public interface ShowService{
    
    ShowResponseDto addShow(ShowEntryDto showEntryDto);
}
