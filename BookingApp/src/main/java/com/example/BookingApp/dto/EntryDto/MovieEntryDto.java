package com.example.BookingApp.dto.EntryDto;

import java.time.LocalDate;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieEntryDto {
    
    String name ;

    @NotNull
    LocalDate releaseDate ;
}
