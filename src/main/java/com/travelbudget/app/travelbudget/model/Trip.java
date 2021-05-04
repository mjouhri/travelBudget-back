package com.travelbudget.app.travelbudget.model;

import com.travelbudget.app.travelbudget.dto.TripDto;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * trip
 */
@Entity
@Table(name = "trip")
public class Trip {

    private Long idtrip;
    private String name;

    /**
     * Constructeur par défaut.
     */
    Trip() {

    }

    public TripDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, TripDto.class);
    }

    @Id
    @Column(name = "idtrip")
    public Long getIdtrip() {
        return idtrip;
    }

    public void setIdtrip(Long idtrip) {
        this.idtrip = idtrip;
    }

    @Column(name = "name")
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
        Trip trip = (Trip) o;
        return Objects.equals(idtrip, trip.idtrip) &&
                Objects.equals(name, trip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtrip, name);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "idtrip=" + idtrip +
                ", name='" + name + '\'' +
                '}';
    }
}
