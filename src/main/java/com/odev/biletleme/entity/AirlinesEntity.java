package com.odev.biletleme.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "airlines")
public class AirlinesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airlines_id")
    private Long airlinesID;
    @Column(name = "name")
    private String name;

    public AirlinesEntity() {
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
