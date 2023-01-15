package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.TheaterEntity;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
    
}
