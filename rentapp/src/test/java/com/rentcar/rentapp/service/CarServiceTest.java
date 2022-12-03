package com.rentcar.rentapp.service;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.storage.Garage;
import com.rentcar.rentapp.storage.RentalStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    //jesli auto istnieje, jest wynajety,
    private CarService carService;
    private Garage garage = new Garage();
    private RentalStorage rentalStorage = new RentalStorage();

    @BeforeEach
    void setup() {
        this.carService = new CarService(garage, rentalStorage);
    }

    @Test
    void checkByVinIfCarIsInDataBase() {
        String vinTest = "VIN12345";
        Car car = new Car("model", null, CarType.PREMIUM, vinTest);
        garage.addToStorage(car);

        Car car2 = garage.getCarByVin(vinTest);

        assertThat(car2).isEqualTo(car);
    }

    @Test
    void shouldReturnPositiveAmountOfDays() {
        //GIVEN
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 3);

        //WHEN
        long daysCalculation = carService.calculateDays(startDate, endDate);

        //THEN
        assertThat(daysCalculation).isGreaterThan(0);
    }

}