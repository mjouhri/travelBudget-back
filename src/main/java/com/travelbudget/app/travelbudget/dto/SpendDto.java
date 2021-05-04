package com.travelbudget.app.travelbudget.dto;

import com.travelbudget.app.travelbudget.model.Spend;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Objects;

public class SpendDto {
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

    public SpendDto() {
    }

    public Spend toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Spend.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

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
        SpendDto spendDto = (SpendDto) o;
        return Objects.equals(id, spendDto.id) &&
                Objects.equals(type, spendDto.type) &&
                Objects.equals(amount, spendDto.amount) &&
                Objects.equals(iconType, spendDto.iconType) &&
                Objects.equals(description, spendDto.description) &&
                Objects.equals(date, spendDto.date) &&
                Objects.equals(country, spendDto.country) &&
                Objects.equals(paymentMethod, spendDto.paymentMethod) &&
                Objects.equals(position, spendDto.position) &&
                Objects.equals(picture, spendDto.picture) &&
                Objects.equals(refund, spendDto.refund);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, iconType, description, date, country, paymentMethod, position, picture, refund);
    }

    @Override
    public String toString() {
        return "SpendDto{" +
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
