package com.odev.biletleme.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class RouteDTO implements Serializable {

    private Long routeID;
    private String departureAirport;
    private String arrivalAirport;
    private Date flightDate;
    private Integer totalSeats;
    private double firstPrice;
    private String airlines;
    @ApiModelProperty(hidden = true, readOnly = true)
    private Double lastPrice;
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer lastSeatCount;

    public RouteDTO() {
    }

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long routeID) {
        this.routeID = routeID;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getLastSeatCount() {
        return lastSeatCount;
    }

    public void setLastSeatCount(Integer lastSeatCount) {
        this.lastSeatCount = lastSeatCount;
    }
}
