package com.rentcar.rentapp.service;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.storage.Garage;
import com.rentcar.rentapp.storage.RentalStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarServiceTest {

    private CarService carService;
    private Garage garage = new Garage();
    private RentalStorage rentalStorage = new RentalStorage();

    @BeforeEach
    void setup() {
        this.carService = new CarService(garage, rentalStorage);
    }

/**
    Brak samochodu w CarStorage - done

    Samochód już wynajęty przez kogoś innego - done

    Data startDate jest późniejsza niż endDate - naprawić implementacje zeby test przechodzil - done

    Jaka jest cena wynajmu samochodu PREMIUM - done

    Jaka jest cena wynajmu samochodu STANDARD - done

    Co się stanie jeżeli vin będzie nullem - naprawić implementacje zeby test przechodzil - done
 */

    @Test
    void checkIfStorageIsEmpty() {
        assertThat(garage.getCarStorageList()).isEmpty();
    }

    @Test
    void checkIfCarIsRentedAlready(){
        //GIVEN
        Car car = new Car("testModel", "testBrand", CarType.PREMIUM, "VIN12345");
        rentalStorage.addRental(new Client(1, "Tester"), car);

        //WHEN
        boolean rentalAvailability = rentalStorage.checkCarAvalability(car);

        //THEN
        assertThat(rentalAvailability).isFalse();
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

    @Test
    void checkPremiumPrice() {
        Car car = new Car("testModel", "testBrand", CarType.PREMIUM, "VIN12345");
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 2);
        double basePrice = 200;

        double finalPrice = carService.carPrice(car, startDate, endDate, basePrice);

        assertThat(finalPrice).isEqualTo(300);
    }

    @Test
    void checkStandardPrice() {
        Car car = new Car("testModel", "testBrand", CarType.STANDARD, "VIN12345");
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 2);
        double basePrice = 200;

        double finalPrice = carService.carPrice(car, startDate, endDate, basePrice);

        assertThat(finalPrice).isEqualTo(200);
    }

    @Test
    void carWithNullVin(){
        Car car = new Car("testModel", "testBrand", CarType.STANDARD, null);

        assertThrows(NullPointerException.class, () -> {
            garage.addToStorage(car);
        });
    }


    @Test
    void checkByVinIfCarIsInDataBase() {
        String vinTest = "VIN12345";
        Car car = new Car("model", "brand", CarType.PREMIUM, vinTest);
        garage.addToStorage(car);

        Car car2 = garage.getCarByVin(vinTest);

        assertThat(car2).isEqualTo(car);
    }



}