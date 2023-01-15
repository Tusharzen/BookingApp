package com.example.BookingApp.dto.ResponseDto;

import java.time.LocalDate;
import java.util.List;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponseDto {
    
    @NotNull
    int id;
    String name;
    LocalDate releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}
