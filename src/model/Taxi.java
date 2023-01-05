package model;

import model.enums.TaxiType;

import java.time.LocalDate;

public class Taxi {
    Long id;
    String model;
    String number;
    String colour;
    LocalDate year;
    TaxiType taxiType;

    public Taxi(Long id, String model, String number, String colour, LocalDate year, TaxiType taxiType) {
        this.id = id;
        this.model = model;
        this.number = number;
        this.colour = colour;
        this.year = year;
        this.taxiType = taxiType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public TaxiType getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(TaxiType taxiType) {
        this.taxiType = taxiType;
    }

    @Override
    public String toString() {
        return "\nTaxi" +
                "\nID: " + id +
                "\nModel: " + model +
                "\nNumber: " + number +
                "\nColour: " + colour +
                "\nYear: " + year +
                "\nTaxi Type: " + taxiType;
    }
}
