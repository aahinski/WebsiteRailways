package com.ahinski.website.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Route {

    private class StationExtension {

        private Station station;
        private Long cost;
        private Long time;

        public Station getStation() {
            return station;
        }

        public void setStation(Station station) {
            this.station = station;
        }

        public Long getCost() {
            return cost;
        }

        public void setCost(Long cost) {
            this.cost = cost;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public StationExtension() {}

        public StationExtension(Station station, Long cost, Long time) {
            this.station = station;
            this.cost = cost;
            this.time = time;
        }

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private List<StationExtension> stations;

    public Route(Long id, String name, List<StationExtension> stations) {
        this.id = id;
        this.name = name;
        this.stations = stations;
    }

    public Route() {}

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

    public List<StationExtension> getStations() {
        return stations;
    }

    public void setStations(List<StationExtension> stations) {
        this.stations = stations;
    }
}