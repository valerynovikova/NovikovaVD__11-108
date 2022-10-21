package ru.itis.novikova.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GuideWeatherDTO {
    private final int id;
    private final UserDTO user;
    private final int weatherId;
    private final String city;


}
