package com.travelbudget.app.travelbudget.model;

import com.travelbudget.app.travelbudget.dto.SpendDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * spend
 */
@Entity
@Table(name = "spend")
public class Spend {
    private Long id;
    private String type;
    private Double amount;
    private String iconType;
    private String description;
    private LocalDate date;
    private String country;
    private String paymentMethod;
    //private String users;
    private String position;
    private String picture;
    private Boolean refund;

    public Spend() {
    }

    public SpendDto toDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, SpendDto.class);
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

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "icon_type")
    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "patmnet_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "refund")
    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spend spend = (Spend) o;
        return Objects.equals(id, spend.id) &&
                Objects.equals(type, spend.type) &&
                Objects.equals(amount, spend.amount) &&
                Objects.equals(iconType, spend.iconType) &&
                Objects.equals(description, spend.description) &&
                Objects.equals(date, spend.date) &&
                Objects.equals(country, spend.country) &&
                Objects.equals(paymentMethod, spend.paymentMethod) &&
                Objects.equals(position, spend.position) &&
                Objects.equals(picture, spend.picture) &&
                Objects.equals(refund, spend.refund);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, iconType, description, date, country, paymentMethod, position, picture, refund);
    }

    @Override
    public String toString() {
        return "Spend{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", iconType='" + iconType + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", country='" + country + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", position='" + position + '\'' +
                ", picture='" + picture + '\'' +
                ", refund=" + refund +
                '}';
    }
}
