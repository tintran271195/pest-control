package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
