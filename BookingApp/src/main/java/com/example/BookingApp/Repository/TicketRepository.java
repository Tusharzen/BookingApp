package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{
    
}
