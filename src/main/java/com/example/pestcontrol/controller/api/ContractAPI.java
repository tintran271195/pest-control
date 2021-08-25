package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Contract;
import com.example.pestcontrol.service.Contract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/v1/contract")
@RestController
@RequiredArgsConstructor
public class ContractAPI {
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<Iterable<Contract>> getAllContract() {
        Iterable<Contract> contracts = contractService.findAll();
        if (contracts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.findById(id);
        if (!contract.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contract.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Contract> save(@RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.save(contract), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contract> deleteContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.findById(id);
        if (!contract.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            contractService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
