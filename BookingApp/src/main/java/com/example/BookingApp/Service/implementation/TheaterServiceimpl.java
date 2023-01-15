package com.example.BookingApp.Service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingApp.Model.TheaterEntity;
import com.example.BookingApp.Model.TheaterSeatEntity;
import com.example.BookingApp.Repository.TheaterRepository;
import com.example.BookingApp.Repository.TheaterSeatRepository;
import com.example.BookingApp.Service.TheaterService;
import com.example.BookingApp.converter.TheaterConverter;
import com.example.BookingApp.dto.EntryDto.TheaterEntryDto;
import com.example.BookingApp.dto.ResponseDto.TheaterResponseDto;
import com.example.BookingApp.dto.ResponseDto.TicketResponseDto;
import com.example.BookingApp.enums.SeatType;
import com.example.BookingApp.enums.TheaterType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TheaterServiceimpl implements TheaterService {
    
    @Autowired
    TheaterRepository theaterRepository ;

    @Autowired
    TheaterSeatRepository theaterSeatRepository ;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {
        
        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);


        //create the Seats
        List<TheaterSeatEntity> seats = createTheaterSeats();


        theaterEntity.setSeats(seats);
        //I need to set the theaterId for all these seats

        theaterEntity.setShows(null);

        for(TheaterSeatEntity theaterSeatsEntity:seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }

        theaterEntity.setTheaterType(TheaterType.SINGLE);

        log.info("The theater entity is "+ theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);
        theaterSeatRepository.saveAll(seats);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);


        return theaterResponseDto;
    }
    public List<TheaterSeatEntity> createTheaterSeats(){
        List<TheaterSeatEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("A1", 100, SeatType.CLASSIC)) ;
        seats.add(getTheaterSeat("A2", 100, SeatType.CLASSIC)) ;
        seats.add(getTheaterSeat("A3", 100, SeatType.CLASSIC)) ;

        seats.add(getTheaterSeat("B1", 200, SeatType.PREMIUM)) ;
        seats.add(getTheaterSeat("B2", 200, SeatType.PREMIUM)) ;
        seats.add(getTheaterSeat("B3", 200, SeatType.PREMIUM)) ;

        theaterSeatRepository.saveAll(seats) ;
        return seats ;
    }

    public TheaterSeatEntity getTheaterSeat(String seatNo, int rate, SeatType seatType){
        return TheaterSeatEntity.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build() ;
    }

    @Override
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
    public TicketResponseDto getTicket(Integer id) {
        return null;
    }
}
