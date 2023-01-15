package com.example.BookingApp.Service;
import com.example.BookingApp.dto.EntryDto.UserEntryDto;
import com.example.BookingApp.dto.ResponseDto.UserResponseDto;

public interface UserService {

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);
}
