package com.rentcar.rentapp;

import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.model.RentalInfo;
import com.rentcar.rentapp.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RentappApplication {

	private final CarService carService;

	public RentappApplication(CarService carService){
		this.carService = carService;
		carService.addCar(new Car("Swift", "Suzuki", CarType.STANDARD, "VIN12345"));
		RentalInfo rentalInfo = carService.rentCar(new Client(2, "name"), "VIN12345", LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 22));
		System.out.println(rentalInfo);

	}

	public static void main(String[] args) {
		SpringApplication.run(RentappApplication.class, args);
	}

}
