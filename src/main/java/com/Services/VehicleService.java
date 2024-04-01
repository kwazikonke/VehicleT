package com.Services;

import java.util.Optional;

import com.example.Vehicle.tracking.system.Vehicle;

public interface VehicleService {
	
	void registerVehicle(Vehicle vehicle);
	Optional<Vehicle> getVehicleById(Long id);
}
