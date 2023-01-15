package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.ShowSeatsEntity;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Integer> {
    
}
