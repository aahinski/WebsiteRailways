package com.ahinski.website.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cost;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "station_id")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="station_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Station station;

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

    public Station getStation() {
        return station;
    }
}
