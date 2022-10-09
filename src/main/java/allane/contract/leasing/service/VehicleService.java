package allane.contract.leasing.service;

import allane.contract.leasing.model.Vehicle;
import allane.contract.leasing.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle createOrUpdate(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

}
