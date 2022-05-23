package com.ahinski.website.models;

import javax.persistence.*;

@Entity
public class StationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cost;

    public StationInformation(Long id, Long cost) {
        this.id = id;
        this.cost = cost;
    }

    public StationInformation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
