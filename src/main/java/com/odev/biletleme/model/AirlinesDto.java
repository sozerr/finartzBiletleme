package com.odev.biletleme.model;

import javax.validation.constraints.NotEmpty;

public class AirlinesDto {
    private Long airlinesID;

    @NotEmpty
    private String name;

    public AirlinesDto() {
    }

    public Long getAirlinesID() {
        return airlinesID;
    }

    public void setAirlinesID(Long airlinesID) {
        this.airlinesID = airlinesID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
