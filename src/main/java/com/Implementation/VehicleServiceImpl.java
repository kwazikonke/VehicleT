package com.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.VehicleRepository;
import com.Services.VehicleService;
import com.example.Vehicle.tracking.system.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    
	@Override
    public void registerVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
	@Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }



}
