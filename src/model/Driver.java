package model;

import model.enums.Gender;
import model.enums.TaxiType;

import java.math.BigDecimal;

public class Driver {
    private Long id;
    private String name;
    private String surName;
    private Gender gender;
    private String phoneNumber;
    private BigDecimal money;
    private TaxiType taxi;

    public Driver(Long id, String name, String surName, Gender gender, String phoneNumber, BigDecimal money, TaxiType taxi) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.taxi = taxi;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public TaxiType getTaxi() {
        return taxi;
    }

    public void setTaxi(TaxiType taxi) {
        this.taxi = taxi;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", money=" + money +
                ", taxi=" + taxi +
                '}';
    }
}
