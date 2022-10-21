package ru.itis.novikova.repositorie;

import lombok.AllArgsConstructor;
import ru.itis.novikova.model.Weather;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
public class WeatherRepositoryJdbcImpl implements WeatherRepository {

	private final DataSource dataSource;

	//language=SQL
	private static final String SQL_SAVE_WEATHER = "INSERT INTO weathers(username, city,  data) VALUES (?, ?, ?, ?, ?)";

	//language=SQL
	private static final String SQL_FIND_ALL = "SELECT * FROM weathers";

	//language=SQL
	private static final String SQL_FIND_BY_CITY = "SELECT * FROM weathers WHERE city = ?";

	//language=SQL

	private final Function<ResultSet, Weather> weatherRowMapper = (row) -> {
		try {
			int userId = row.getInt("city");
			String title = row.getString("username");
			String data = row.getString("data");
			return new Weather(username, city, data);
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		}
	};

	@Override
	public void save(Weather weather) {
		try (Connection connection = dataSource.getConnection();
		     PreparedStatement statement = connection.prepareStatement(SQL_SAVE_WEATHER)) {
			statement.setInt(1, weather.getUserId());
			statement.setString(2, weather.getCity());
			statement.setString(3, weather.getUsername());
			statement.setString(5, weather.getData());
			statement.executeUpdate();
		} catch (SQLException throwables) {
			throw new IllegalArgumentException(throwables);
		}
	}

	@Override
	public List<Weather> findAll() {
		try (Connection connection = dataSource.getConnection();
		     PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL)) {
			ResultSet resultSet = statement.executeQuery();
			List<Weather> list = new ArrayList<>();
			while (resultSet.next()) {
				list.add(weatherRowMapper.apply(resultSet));
			}
			return list;
		} catch (SQLException throwables) {
			throw new IllegalArgumentException(throwables);
		}
	}

	@Override
	public Optional<Weather> findByCity(int city) {
		try (Connection connection = dataSource.getConnection();
		     PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_CITY)) {
			statement.setInt(1, city);
			ResultSet row = statement.executeQuery();
			if (row.next()){
				Weather weather = weatherRowMapper.apply(row);
				return Optional.of(weather);
			} else {
				return Optional.empty();
			}
		} catch (SQLException throwables) {
			throw new IllegalArgumentException(throwables);
		}
	}


	@Override
	public void delete(int id) {

	}
}
