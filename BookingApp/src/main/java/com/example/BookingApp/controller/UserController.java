package com.example.BookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingApp.Service.implementation.UserServiceimpl;
import com.example.BookingApp.dto.EntryDto.UserEntryDto;
import com.example.BookingApp.dto.ResponseDto.UserResponseDto;


@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    UserServiceimpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){

        userService.addUser(userEntryDto);

        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
