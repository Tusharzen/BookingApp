package com.example.BookingApp.Service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingApp.Model.MovieEntity;
import com.example.BookingApp.Model.ShowEntity;
import com.example.BookingApp.Model.ShowSeatsEntity;
import com.example.BookingApp.Model.TheaterEntity;
import com.example.BookingApp.Model.TheaterSeatEntity;
import com.example.BookingApp.Repository.MovieRepository;
import com.example.BookingApp.Repository.ShowRepository;
import com.example.BookingApp.Repository.ShowSeatsRepository;
import com.example.BookingApp.Repository.TheaterRepository;
import com.example.BookingApp.Service.ShowService;
import com.example.BookingApp.converter.ShowConverter;
import com.example.BookingApp.dto.EntryDto.ShowEntryDto;
import com.example.BookingApp.dto.ResponseDto.ShowResponseDto;

@Service
public class ShowServiceimpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();


        showEntity.setMovie(movieEntity); //Why are we setting these varibble
        showEntity.setTheater(theaterEntity);

        showEntity = showRepository.save(showEntity);


        //We need to pass the list of the theater seats
        List<ShowSeatsEntity> showSeatsEntityList = generateShowEntitySeats(theaterEntity.getSeats(),showEntity);
        showSeatsRepository.saveAll(showSeatsEntityList);
        //We need to create Response Show Dto.

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();


        for(TheaterSeatEntity tse : theaterSeatsEntityList){

            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }


        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);
        return showSeatsEntityList;

    }
    
}
