package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Station;
import com.example.pestcontrol.service.Station.IStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/station")
@RequiredArgsConstructor
public class StationAPI {
    private final IStationService stationService;

    @GetMapping()
    public ResponseEntity<Iterable<Station>> getAllStation() {
        Iterable<Station> stations = stationService.findAll();
        if (stations == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(stations, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        Optional<Station> station = stationService.findById(id);
        if (!station.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(station.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Station> saveStation(@RequestBody Station station) {
        return new ResponseEntity<>(stationService.save(station), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Station> deleteStationById(@PathVariable Long id) {
        Optional<Station> station = stationService.findById(id);
        if (!station.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            stationService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
