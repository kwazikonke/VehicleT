package com.example.Vehicle.tracking.system;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
    private VehicleService vehicleService;
	
	@PostMapping("/register")
    public ResponseEntity<String> registerVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.registerVehicle(vehicle);
        return ResponseEntity.ok("Vehicle registered successfully");
    }
	@GetMapping("/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable("id") Long id) {
        try {
            Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
            if (vehicle != null) {
                return ResponseEntity.ok(vehicle); 
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
            }
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch vehicle: " + e.getMessage());
        }
    }
}
