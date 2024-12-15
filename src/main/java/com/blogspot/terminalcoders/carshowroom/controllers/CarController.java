package com.blogspot.terminalcoders.carshowroom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.terminalcoders.carshowroom.beans.Message;
import com.blogspot.terminalcoders.carshowroom.entity.Car;
import com.blogspot.terminalcoders.carshowroom.services.CarService;

@RestController
public class CarController {
	
	@Autowired
	CarService carService;
	
	@PostMapping("car/create")
	public ResponseEntity<?> createCar(@RequestBody Car car) {
		carService.saveOrUpdate(car);
		return new ResponseEntity<>(car, HttpStatus.CREATED) ;
	}
	
	@GetMapping("car/list")
	public ResponseEntity<?>  getCars() {
		return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK) ;
	}
	
	@PatchMapping("car/update")
	public ResponseEntity<?>  modifyCar(@RequestBody Car car) {
		carService.saveOrUpdate(car);
		return new ResponseEntity<>(car, HttpStatus.FOUND);
	}
	
	@DeleteMapping("car/delete/{id}")
	public ResponseEntity<?>  deleteCar(@PathVariable("id") Long id) {
		carService.deleteCar(id);
		Message message = new Message("message", "Deleted");
		return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
	}
}
