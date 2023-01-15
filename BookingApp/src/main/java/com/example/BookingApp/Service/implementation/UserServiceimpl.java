package com.example.BookingApp.Service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingApp.Model.UserEntity;
import com.example.BookingApp.Repository.UserRepository;
import com.example.BookingApp.Service.UserService;
import com.example.BookingApp.converter.UserConverter;
import com.example.BookingApp.dto.EntryDto.UserEntryDto;
import com.example.BookingApp.dto.ResponseDto.UserResponseDto;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepository userRepository ;

    public void addUser(UserEntryDto userdto){
        UserEntity userEntity = UserConverter.convertDtoToEntity(userdto) ;
        userRepository.save(userEntity) ;

    }

    public UserResponseDto getUser(int id){
    
        UserEntity userEntity = userRepository.findById(id).get() ;

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;

    }
    
}
