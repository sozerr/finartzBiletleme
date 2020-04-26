package com.odev.biletleme.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BuyTicketDto {
    @NotNull
    @ApiModelProperty(required = true)
    private Long routeID;

    @NotEmpty
    @ApiModelProperty(required = true)
    private String passengerName;

    @NotEmpty
    @ApiModelProperty(required = true)
    private String passgerSurname;

    public BuyTicketDto() {
    }

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long routeID) {
        this.routeID = routeID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassgerSurname() {
        return passgerSurname;
    }

    public void setPassgerSurname(String passgerSurname) {
        this.passgerSurname = passgerSurname;
    }
}
