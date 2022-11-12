package com.rentcar.rentapp.storage;

import com.rentcar.rentapp.CarType;
import com.rentcar.rentapp.model.Car;
import com.rentcar.rentapp.model.Client;
import com.rentcar.rentapp.model.Rental;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalStorage {

    private final List<Rental> rentalStorage = new ArrayList<Rental>();

    public RentalStorage(){
        rentalStorage.add(new Rental(new Client(1, "Jakub"), new Car("Vitara", "Suzuki", CarType.PREMIUM, "67890")));
    }

    public List<Rental> getAllRecords(){
        return rentalStorage;
    }

//    public boolean checkCarAvalability(Car car){
//        if(rentalStorage.contains(car)){
//            return true;
//        }else
//            return false;
//    }


    public Rental addRental(Client client, Car car){
        int clientId = client.getId();
        String clientName = client.getName();

        Rental rental = new Rental(new Client(clientId, clientName), car);
        rentalStorage.add(rental);
        return rental;

    }

}
