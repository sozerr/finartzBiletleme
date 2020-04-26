package com.odev.biletleme.model;

import javax.validation.constraints.NotEmpty;

public class AirportDto {

    @NotEmpty
    private String name;
    private String country;
    private String city;
    private Long airportID;

    public AirportDto() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getAirportID() {
        return airportID;
    }

    public void setAirportID(Long airportID) {
        this.airportID = airportID;
    }
}
