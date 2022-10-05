package allane.contract.leasing.controller;

import allane.contract.leasing.model.LeasingContract;
import allane.contract.leasing.model.Vehicle;
import allane.contract.leasing.service.LeasingContractService;
import allane.contract.leasing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LeasingContractController {

    @Autowired
    LeasingContractService leasingContractService;

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/leasingContracts")
    public List<LeasingContract> getLeasingContracts() {
        return leasingContractService.findAllLeasingContracts();
    }


    @GetMapping("/leasingContracts/{id}")
    public LeasingContract getLeasingContractById(@PathVariable("id") long id) {
        Optional<LeasingContract> leasingContractData = leasingContractService.findLeasingContractById(id);

        if (leasingContractData.isPresent()) {
            return leasingContractData.get();
        } else {
            return null;
        }
    }






}
