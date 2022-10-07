package allane.contract.leasing.controller;

import allane.contract.leasing.model.Customer;
import allane.contract.leasing.model.LeasingContract;
import allane.contract.leasing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getLeasingContracts() {
        return customerService.findAllCustomers();
    }



    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") long id) {
        Optional<Customer> customerData = customerService.findCustomerById(id);

        if (customerData.isPresent()) {
            return customerData.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName(customer.getLastName());
            newCustomer.setBirthDate(customer.getBirthDate());

            Customer _customer = customerService.create(newCustomer);

            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        Optional<Customer> customerData = customerService.findCustomerById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setFirstName(customer.getFirstName());
            _customer.setLastName(customer.getLastName());
            _customer.setBirthDate(customer.getBirthDate());
            return new ResponseEntity<>(customerService.create(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
