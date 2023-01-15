package com.example.BookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingApp.Model.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{
    
    boolean existsByName(String name) ;
}
