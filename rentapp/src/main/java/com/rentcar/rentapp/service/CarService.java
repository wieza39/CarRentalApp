package com.rentcar.rentapp.service;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.model.Rental;
import com.rentcar.rentapp.storage.Garage;
import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.storage.RentalStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    
    private final Garage garage;
    private final RentalStorage rentalStorage;
    
    public CarService(Garage garage, RentalStorage rentalStorage) {
        this.garage = garage;
        this.rentalStorage = rentalStorage;
    }

    public void addCar(String model, String brand, CarType type, String vin){
        garage.addToStorage(model, brand, type, vin);
    }

    public List<Car> getAllCars(){
        return garage.getCarStorageList();
    }

    public List<Rental> getAllRentals(){
        return rentalStorage.getAllRecords();
    }

    public Rental rentCar(Client client, String vin) {

        List<Rental> rentalList = rentalStorage.getAllRecords();

        Car car = garage.getCarByVin(vin);

        if(rentalList.contains(car)){
            Rental rental = rentalStorage.addRental(client, car);
            return rental;
        }
        return null;
    }

}
