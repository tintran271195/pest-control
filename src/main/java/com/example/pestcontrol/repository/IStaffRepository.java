package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaffRepository extends JpaRepository<Staff,Long> {
}
