package com.travelbudget.app.travelbudget.service;

import com.travelbudget.app.travelbudget.dto.TripDto;
import com.travelbudget.app.travelbudget.model.Trip;
import com.travelbudget.app.travelbudget.repository.TripRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TripService {

    private TripRepository tripRepository;

    TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<TripDto> getTrips() {
        return tripRepository
                .getTrips()
                .parallelStream()
                .map(Trip::toDto)
                .collect(Collectors.toList());
    }

    public TripDto getById(Long idTrip) {
        return tripRepository.getById(idTrip).toDto();
    }

    public void create(TripDto tripDto) {
        tripRepository.create(tripDto.toEntity());
    }

    public void update(TripDto tripDto) {
        tripRepository.update(tripDto.toEntity());
    }

    public void delete(TripDto tripDto) {
        tripRepository.delete(tripDto.toEntity());
    }

}
