package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.TheaterSeatEntity;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer>{
    
}
