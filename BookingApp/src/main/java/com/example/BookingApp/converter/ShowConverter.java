package com.example.BookingApp.converter;

import com.example.BookingApp.Model.ShowEntity;
import com.example.BookingApp.dto.EntryDto.ShowEntryDto;
import com.example.BookingApp.dto.ResponseDto.ShowResponseDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    
    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterDto(showEntryDto.getTheaterResponseDto())
                .build();
    }
}
