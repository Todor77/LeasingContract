package allane.contract.leasing.controller;

import allane.contract.leasing.model.Customer;
import allane.contract.leasing.model.Vehicle;
import allane.contract.leasing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable("id") long id) {
        Optional<Vehicle> vehicleData = vehicleService.findVehicleById(id);

        if (vehicleData.isPresent()) {
            return vehicleData.get();
        } else {
            return null;
        }
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setBrand(vehicle.getBrand());
            newVehicle.setModel(vehicle.getModel());
            newVehicle.setVin(vehicle.getVin());
            newVehicle.setPrice(vehicle.getPrice());
            newVehicle.setYear(vehicle.getYear());

            Vehicle _vehicle = vehicleService.create(newVehicle);

            return new ResponseEntity<>(_vehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleDate = vehicleService.findVehicleById(id);

        if (vehicleDate.isPresent()) {
            Vehicle _vehicle = vehicleDate.get();
            _vehicle.setBrand(vehicle.getBrand());
            _vehicle.setModel(vehicle.getModel());
            _vehicle.setYear(vehicle.getYear());
            _vehicle.setVin(vehicle.getVin());
            _vehicle.setPrice(vehicle.getPrice());
            return new ResponseEntity<>(vehicleService.create(_vehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
