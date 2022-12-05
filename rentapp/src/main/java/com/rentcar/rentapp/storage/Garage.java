package com.rentcar.rentapp.storage;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Garage {

    private List<Car> carStorage = new ArrayList<>();

    public void addToStorage(Car car) {
        carStorage.add(car);
    }

    public List<Car> getCarStorageList(){
        return carStorage;
    }

    public Car getCarByVin(String vin) {
        return carStorage.stream().filter(car -> car.getVin() == vin).findFirst().orElse(null);
    }

}
