package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Customer;
import com.example.pestcontrol.service.Customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerAPI {
    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Iterable<Customer>> getAllCustomer(){
        Iterable<Customer> customers = customerService.findAll();
        if(customers == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
    }

    @PostMapping()
//   Nếu save không được thì bỏ @RequestBody vào Khánh Said
    public ResponseEntity<Customer> saveCustomer(Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            customerService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
