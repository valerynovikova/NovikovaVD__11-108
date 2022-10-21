package ru.itis.novikova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private int id;

    public Weather(int userId, String city, String data) {
        this.userId = userId;
        this.city = city;
        this.data = data;
    }

    private int userId;
    private String city;
    private String data;

}
