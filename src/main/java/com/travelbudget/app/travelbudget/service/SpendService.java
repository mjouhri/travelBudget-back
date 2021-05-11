package com.travelbudget.app.travelbudget.service;

import com.travelbudget.app.travelbudget.dto.SpendDto;
import com.travelbudget.app.travelbudget.model.Spend;
import com.travelbudget.app.travelbudget.model.Trip;
import com.travelbudget.app.travelbudget.repository.SpendRepository;
import com.travelbudget.app.travelbudget.repository.TripRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpendService {

    private SpendRepository spendRepository;
    private TripRepository tripRepository;

    public SpendService(SpendRepository spendRepository, TripRepository tripRepository) {
        this.spendRepository = spendRepository;
        this.tripRepository = tripRepository;
    }

    public List<SpendDto> getSpends() {
        return spendRepository
                .getSpends()
                .parallelStream()
                .map(Spend::toDto)
                .collect(Collectors.toList());
    }

    public SpendDto getById(Long idSpend) {
        return spendRepository.getById(idSpend).toDto();
    }

    public void create(SpendDto spendDto, Long idTrip) {
        Trip trip = tripRepository.getById(idTrip);
        trip.getSpends().add(spendDto.toEntity());
        tripRepository.update(trip);
    }

    public void update(SpendDto spendDto) {
        spendRepository.update(spendDto.toEntity());
    }

    public void delete(Long id) {
        spendRepository.delete(spendRepository.getById(id));
    }

}
