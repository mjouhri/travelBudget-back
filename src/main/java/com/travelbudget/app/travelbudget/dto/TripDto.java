package com.travelbudget.app.travelbudget.dto;

import com.travelbudget.app.travelbudget.model.Trip;
import org.modelmapper.ModelMapper;

import java.util.Objects;

/**
 * trip
 */
public class TripDto {
    private Long idtrip;
    private String name;

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

    public Long getIdtrip() {
        return idtrip;
    }

    public void setIdtrip(Long idtrip) {
        this.idtrip = idtrip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto tripDto = (TripDto) o;
        return Objects.equals(idtrip, tripDto.idtrip) &&
                Objects.equals(name, tripDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtrip, name);
    }

    @Override
    public String toString() {
        return "TripDto{" +
                "idtrip=" + idtrip +
                ", name='" + name + '\'' +
                '}';
    }
}
