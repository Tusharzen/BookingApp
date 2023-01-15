package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
