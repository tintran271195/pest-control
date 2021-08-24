package com.example.pestcontrol.service.Station;

import com.example.pestcontrol.model.Station;
import com.example.pestcontrol.repository.IStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService implements IStationService {
    private final IStationRepository stationRepository;

    @Override
    public Iterable<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Long id) {
        return stationRepository.findById(id);
    }

    @Override
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public void remove(Long id) {
        stationRepository.deleteById(id);
    }
}
