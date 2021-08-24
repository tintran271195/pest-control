package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Long> {
}
