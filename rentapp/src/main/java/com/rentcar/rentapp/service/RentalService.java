package com.rentcar.rentapp.service;

import com.rentcar.rentapp.storage.RentalStorage;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private RentalStorage rentalStorage;

    public RentalService(RentalStorage rentalStorage) {
        this.rentalStorage = rentalStorage;
    }


}
