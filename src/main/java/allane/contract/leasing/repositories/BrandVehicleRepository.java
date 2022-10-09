package allane.contract.leasing.repositories;

import allane.contract.leasing.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandVehicleRepository extends JpaRepository<Brand, Long> {

}
