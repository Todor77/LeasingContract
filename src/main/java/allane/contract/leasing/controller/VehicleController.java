package allane.contract.leasing.controller;

import allane.contract.leasing.model.Brand;
import allane.contract.leasing.model.Model;
import allane.contract.leasing.model.Vehicle;
import allane.contract.leasing.service.BrandVehicleService;
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

    @Autowired
    private BrandVehicleService brandVehicleService;

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
            Optional<Brand> brand = brandVehicleService.findBrandById(Long.parseLong(vehicle.getBrand()));

            Vehicle newVehicle = new Vehicle();

            //I know that is not the smartest solution,
            if(brand.isPresent()) {
                newVehicle.setBrand(brand.get().getName());

                for(Model model : brand.get().getModels()) {
                    if(model.getId().toString().equals(vehicle.getModel())) {
                        newVehicle.setModel(model.getName());
                    }
                }
            }
            newVehicle.setVin(vehicle.getVin());
            newVehicle.setPrice(vehicle.getPrice());
            newVehicle.setYear(vehicle.getYear());

            Vehicle _vehicle = vehicleService.createOrUpdate(newVehicle);

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
            return new ResponseEntity<>(vehicleService.createOrUpdate(_vehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
