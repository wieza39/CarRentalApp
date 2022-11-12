package com.rentcar.rentapp.storage;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Garage {

    private List<Car> carStorage = new ArrayList<>();

    public void addToStorage(String model, String brand, CarType type, String vin){
        Car car = new Car(model, brand, type, vin);
        carStorage.add(car);
    }

    public List<Car> getCarStorageList(){
        return carStorage;
    }

    public Car getCarByVin(String vin){
        for (Car car : carStorage){
            if(car.getVin() == vin){
                return car;
            }
        }
        return null;
    }

}
