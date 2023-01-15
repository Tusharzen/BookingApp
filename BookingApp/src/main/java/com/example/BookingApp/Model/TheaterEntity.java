package com.example.BookingApp.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.BookingApp.enums.SeatType;
import com.example.BookingApp.enums.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "theaters")
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "address", nullable = false)
    private String address ;

    @Column(name = "city", nullable = false)
    private String city ;

    private TheaterType theaterType  ;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowEntity> shows ;
    
    @OneToMany(mappedBy = "theater" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheaterSeatEntity> seats ;
}
