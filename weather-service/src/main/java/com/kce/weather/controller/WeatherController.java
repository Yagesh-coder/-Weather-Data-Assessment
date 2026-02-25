package com.kce.weather.controller;

import com.kce.weather.entity.WeatherRecord;
import com.kce.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

	private final WeatherService service;

	@PostMapping("/load")
	public String load() {

		service.loadCsv("testset.csv");

		return "loaded";
	}

	@GetMapping
	public List<WeatherRecord> all(@RequestParam(required = false) String sort) {

		return service.getAll(sort);
	}

	@GetMapping("/filter")
	public List<WeatherRecord> filter(@RequestParam(required = false) Double minTemp,
			@RequestParam(required = false) Double maxTemp, @RequestParam(required = false) String condition) {

		return service.filter(minTemp, maxTemp, condition);
	}

}