package allane.contract.leasing.repositories;

import allane.contract.leasing.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findVehiclesByBrandAndAndModel(String brand, String model);
}
