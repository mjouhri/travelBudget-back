package com.travelbudget.app.travelbudget.dto;

import com.travelbudget.app.travelbudget.model.Spend;
import com.travelbudget.app.travelbudget.model.Trip;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

/**
 * trip
 */
public class TripDto extends BaseDto{
    private Long id;
    private String name;
    private List<Spend> spends;

    /**
     * Constructeur par défaut.
     */
    TripDto() {

    }

    /**
     * Convertion en Objet Contact.
     *
     * @return Contact.
     */
    public Trip toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Trip.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Spend> getSpends() {
        return spends;
    }

    public void setSpends(List<Spend> spends) {
        this.spends = spends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto tripDto = (TripDto) o;
        return Objects.equals(id, tripDto.id) &&
                Objects.equals(name, tripDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TripDto{" +
                "idtrip=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
