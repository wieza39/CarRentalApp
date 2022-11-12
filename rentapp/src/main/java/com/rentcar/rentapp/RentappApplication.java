package com.rentcar.rentapp;

import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentappApplication {

	private final CarService carService;

	public RentappApplication(CarService carService){
		this.carService = carService;
		carService.addCar("Swift", "Suzuki", CarType.STANDARD, "VIN12345");
		carService.rentCar(new Client(2, "name"), "VIN12345");
		System.out.println(carService.getAllCars());
		System.out.println(carService.getAllRentals());

	}

	public static void main(String[] args) {
		SpringApplication.run(RentappApplication.class, args);
	}

}
