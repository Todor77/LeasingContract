package allane.contract.leasing.controller;

import allane.contract.leasing.model.Brand;
import allane.contract.leasing.service.BrandVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {


    @Autowired
    private BrandVehicleService brandVehicleService;

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return brandVehicleService.findAllBrands();
    }

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable("id") long id) {
        Optional<Brand> brandData = brandVehicleService.findBrandById(id);

        if (brandData.isPresent()) {
            return brandData.get();
        } else {
            return null;
        }
    }

    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        try {
            Brand newBrand = new Brand();
            newBrand.setName(brand.getName());

            Brand _brand = brandVehicleService.create(newBrand);

            return new ResponseEntity<>(_brand, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
