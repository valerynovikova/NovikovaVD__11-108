package ru.itis.novikova.servlet;

import ru.itis.novikova.dto.UserDTO;
import ru.itis.novikova.model.Weather;
import ru.itis.novikova.service.WeatherService;
import ru.itis.novikova.service.WeatherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(urlPatterns = "")
@MultipartConfig(
		maxFileSize = 5 * 1024 * 1024,
		maxRequestSize = 10 * 1024 * 1024
)
public class AddWeatherServlet extends HttpServlet {

	private WeatherService weatherService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String city = req.getParameter("city");
		UserDTO userDTO = (UserDTO) req.getAttribute("user");
		int userId = userDTO.getId();


		Date date = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

		Weather weather = new Weather(username, city, formatForDateNow.format(date));
		weatherService.save(weather);

		resp.sendRedirect("");
	}

	@Override
	public void init() throws ServletException {
		weatherService = new WeatherServiceImpl();

	}
}
