package com.rentcar.rentapp.service;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.model.Rental;
import com.rentcar.rentapp.model.RentalInfo;
import com.rentcar.rentapp.storage.Garage;
import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.storage.RentalStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class CarService {

    private double price = 200;

    private final Garage garage;
    private final RentalStorage rentalStorage;

    public CarService(Garage garage, RentalStorage rentalStorage) {
        this.garage = garage;
        this.rentalStorage = rentalStorage;
    }

    public void addCar(String model, String brand, CarType type, String vin) {
        garage.addToStorage(model, brand, type, vin);
    }

    public List<Car> getAllCars() {
        return garage.getCarStorageList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getAllRecords();
    }

    public double checkPriceRate(Car car) {

        switch (car.getCarType()) {
            case STANDARD -> {
                return 1;
            }
            case PREMIUM -> {
                return 1.5;
            }
            default -> {
                return 0;
            }
        }
    }

    public long calculateDays(LocalDate startDate, LocalDate endDate){
        return DAYS.between(startDate, endDate);
    }
    public RentalInfo rentCar(Client client, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = garage.getCarByVin(vin);
        boolean availability = rentalStorage.checkCarAvalability(car);

        //price calculation
        double carPrice = price * checkPriceRate(car) * calculateDays(startDate, endDate);

        RentalInfo rentalInfo = new RentalInfo(carPrice, startDate, endDate);

        if (availability) {
            rentalStorage.addRental(client, car);
            return rentalInfo;
        } else
            return null;
    }
}
