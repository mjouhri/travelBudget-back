package com.travelbudget.app.travelbudget.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.travelbudget.app.travelbudget.model.Spend;
import com.travelbudget.app.travelbudget.model.Trip;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * trip
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripDto extends BaseDto{
    private Long id;
    private String name;
    private Double budget;
    private String currency;
    private String dateDebut;
    private String dateFin;
    private String picture;
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDateDebut() {
        return getFormattedLocalDate(this.dateDebut);
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return getFormattedLocalDate(this.dateFin);
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto tripDto = (TripDto) o;
        return Objects.equals(id, tripDto.id) &&
                Objects.equals(name, tripDto.name) &&
                Objects.equals(budget, tripDto.budget) &&
                Objects.equals(currency, tripDto.currency) &&
                Objects.equals(dateDebut, tripDto.dateDebut) &&
                Objects.equals(dateFin, tripDto.dateFin) &&
                Objects.equals(picture, tripDto.picture) &&
                Objects.equals(spends, tripDto.spends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, budget, currency, dateDebut, dateFin, picture, spends);
    }

    @Override
    public String toString() {
        return "TripDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", currency='" + currency + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", picture='" + picture + '\'' +
                ", spends=" + spends +
                '}';
    }
}
