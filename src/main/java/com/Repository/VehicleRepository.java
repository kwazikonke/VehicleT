package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.tracking.system.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	List<Vehicle> findByName(String name);
	
	List<Vehicle> findByModelContaining(String keyword);
	
	List<Vehicle> findByNameAndModel(String name, String model);
}
