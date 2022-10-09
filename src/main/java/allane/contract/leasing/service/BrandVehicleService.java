package allane.contract.leasing.service;

import allane.contract.leasing.model.Brand;
import allane.contract.leasing.repositories.BrandVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandVehicleService {

    private final BrandVehicleRepository brandVehicleRepository;

    public BrandVehicleService(BrandVehicleRepository brandVehicleRepository) {
        this.brandVehicleRepository = brandVehicleRepository;
    }

    public List<Brand> findAllBrands() {
        return brandVehicleRepository.findAll();
    }

    public Optional<Brand> findBrandById(Long id) {
        return brandVehicleRepository.findById(id);
    }

    public Brand create(Brand brand) {
        return brandVehicleRepository.save(brand);
    }


}
