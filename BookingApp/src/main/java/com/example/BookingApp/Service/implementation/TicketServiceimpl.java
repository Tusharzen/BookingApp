package com.example.BookingApp.Service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingApp.Model.ShowEntity;
import com.example.BookingApp.Model.ShowSeatsEntity;
import com.example.BookingApp.Model.TicketEntity;
import com.example.BookingApp.Model.UserEntity;
import com.example.BookingApp.Repository.ShowRepository;
import com.example.BookingApp.Repository.TicketRepository;
import com.example.BookingApp.Repository.UserRepository;
import com.example.BookingApp.Service.TicketService;
import com.example.BookingApp.converter.TicketConverter;
import com.example.BookingApp.dto.BookTicketRequestDto;
import com.example.BookingApp.dto.ResponseDto.TicketResponseDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TicketServiceimpl implements TicketService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {

        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;

    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();


        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();

       // for(ShowSeatsEntity seat: showSeatsEntityList) System.out.print(seat+" ");


//        //Another way to iterate. Try to study about it.
//        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
//                .stream()
//                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
//                        requestSeats.contains(seat.getSeatNumber()))
//                .collect(Collectors.toList());



        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        for(ShowSeatsEntity seat: bookedSeats) System.out.println(seat);
        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder().
                user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllotedSeat(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in the Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTickets().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        
        return TicketConverter.convertEntityToDto(ticketEntity);


    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }
}
