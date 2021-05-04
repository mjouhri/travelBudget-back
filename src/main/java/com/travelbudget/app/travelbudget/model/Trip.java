package com.travelbudget.app.travelbudget.model;

import com.travelbudget.app.travelbudget.dto.TripDto;
import org.modelmapper.ModelMapper;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * trip
 */
@Entity
@Table(name = "trip")
public class Trip extends BaseModel{

    private Long id;
    private String name;
    private Double budget;
    private String currency;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String picture;
    private List<Spend> spends;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "budget")
    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "date_debut")
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Column(name = "date_fin")
    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
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
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) &&
                Objects.equals(name, trip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "idtrip=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
