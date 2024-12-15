package com.blogspot.terminalcoders.carshowroom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspot.terminalcoders.carshowroom.entity.Car;
import com.blogspot.terminalcoders.carshowroom.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository carRepository;

	public void saveOrUpdate(Car car) {
		carRepository.save(car);
	}

	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();
		carRepository.findAll().forEach(c -> { System.out.println("AKP - " + c.toString()); cars.add(c); });
		return cars;
	}
	
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
