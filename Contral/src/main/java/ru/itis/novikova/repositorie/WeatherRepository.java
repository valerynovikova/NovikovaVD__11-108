package ru.itis.novikova.repositorie;

import ru.itis.novikova.model.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository {
	void save(Weather weather);
	List<Weather> findAll();
	Optional<ru.itis.novikova.models.Weather> findById(int id);
	List<Weather> findAllByCity(int city);

	void delete(int id);
}
