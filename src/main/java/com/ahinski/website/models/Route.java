package com.ahinski.website.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    private List<StationInformation> stationInformationList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    private List<Train> trains = new ArrayList<>();

    public Route() {}

    public Route(Long id, String name, List<StationInformation> stationInformationList, List<Train> trains) {
        this.id = id;
        this.name = name;
        this.stationInformationList = stationInformationList;
        this.trains = trains;
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

    public List<StationInformation> getStationInformationList() {
        return stationInformationList;
    }

    public void setStationInformationList(List<StationInformation> stationInformationList) {
        this.stationInformationList = stationInformationList;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}