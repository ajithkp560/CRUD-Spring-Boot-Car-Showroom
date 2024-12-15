package com.blogspot.terminalcoders.carshowroom.repositories;

import org.springframework.data.repository.CrudRepository;
import com.blogspot.terminalcoders.carshowroom.entity.Car;  

public interface CarRepository extends CrudRepository<Car, Long>{

}
