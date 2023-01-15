package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.ShowEntity;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
    
}
