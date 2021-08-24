package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Long> {
}
