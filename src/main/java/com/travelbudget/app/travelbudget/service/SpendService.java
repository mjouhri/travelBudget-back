package com.travelbudget.app.travelbudget.service;

import com.travelbudget.app.travelbudget.dto.SpendDto;
import com.travelbudget.app.travelbudget.model.Spend;
import com.travelbudget.app.travelbudget.repository.SpendRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpendService {

    private SpendRepository spendRepository;

    public SpendService(SpendRepository spendRepository) {
        this.spendRepository = spendRepository;
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

    public void create(SpendDto spendDto) {
        spendRepository.create(spendDto.toEntity());
    }

    public void update(SpendDto spendDto) {
        spendRepository.update(spendDto.toEntity());
    }

    public void delete(Long id) {
        spendRepository.delete(spendRepository.getById(id));
    }

}
