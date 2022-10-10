package allane.contract.leasing.controller;

import allane.contract.leasing.model.Customer;
import allane.contract.leasing.model.LeasingContract;
import allane.contract.leasing.model.Vehicle;
import allane.contract.leasing.service.CustomerService;
import allane.contract.leasing.service.LeasingContractService;
import allane.contract.leasing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    CustomerService customerService;

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

    @PostMapping("/leasingContracts")
    public ResponseEntity<LeasingContract> createLeasingContract(@RequestBody LeasingContract leasingContract) {
        try {
            LeasingContract newleasingContract = new LeasingContract();
            newleasingContract.setContractNumber(leasingContract.getContractNumber());
            newleasingContract.setMonthlyRate(leasingContract.getMonthlyRate());
            newleasingContract.setCustomer(leasingContract.getCustomer());

            Optional<Vehicle> optionalVehiclevehicle = vehicleService.findVehicleById(leasingContract.getVehicle().getId());
            Optional<Customer> optionalCustomer = customerService.findCustomerById(leasingContract.getCustomer().getId());

            Vehicle vehicle = optionalVehiclevehicle.get();
            vehicle.setAvailable(false);

            if(optionalVehiclevehicle.isPresent()) {
                newleasingContract.setVehicle(vehicle);
            }

            if(optionalCustomer.isPresent()) {
                newleasingContract.setCustomer(optionalCustomer.get());
            }

            LeasingContract _leasingContract = leasingContractService.createOrUpdate(newleasingContract);

            return new ResponseEntity<>(_leasingContract, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/leasingContracts/{id}")
    public ResponseEntity<LeasingContract> updateLeasingContract(@PathVariable("id") long id, @RequestBody LeasingContract leasingContract) {
        Optional<LeasingContract> leasingContractData = leasingContractService.findLeasingContractById(id);

        if (leasingContractData.isPresent()) {
            LeasingContract _leasingContract = leasingContractData.get();
            _leasingContract.setContractNumber(leasingContract.getContractNumber());
            _leasingContract.setMonthlyRate(leasingContract.getMonthlyRate());
            _leasingContract.setCustomer(leasingContract.getCustomer());

            //i know it is not nice writen but, those changes are made the last day, and is better to be working,
            Optional<Vehicle> optionalVehiclevehicle = vehicleService.findVehicleById(leasingContract.getVehicle().getId());
            Vehicle vehiclesByBrandAndAndModel = vehicleService.findVehiclesByBrandAndAndModel(leasingContract.getVehicle().getBrand(), leasingContract.getVehicle().getModel());

            vehiclesByBrandAndAndModel.setAvailable(false);
            _leasingContract.setVehicle(vehiclesByBrandAndAndModel);


            ResponseEntity<LeasingContract> leasingContractResponseEntity = new ResponseEntity<>(leasingContractService.createOrUpdate(_leasingContract), HttpStatus.OK);
           if(leasingContractResponseEntity.getStatusCode().is2xxSuccessful()) {
               Vehicle updateOldVehicle = vehicleService.findVehiclesByBrandAndAndModel(optionalVehiclevehicle.get().getBrand(), optionalVehiclevehicle.get().getModel());
               updateOldVehicle.setAvailable(true);
               vehicleService.createOrUpdate(updateOldVehicle);
           }
            return leasingContractResponseEntity;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
