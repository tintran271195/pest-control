package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStationRepository extends JpaRepository<Station, Long> {
}
