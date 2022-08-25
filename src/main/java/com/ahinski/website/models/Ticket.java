package com.ahinski.website.models;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="departure_station_id", referencedColumnName = "id", insertable = false, updatable = false)
    private StationInformation departureStationId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="train_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Train train;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="arrival_station_id", referencedColumnName = "id", insertable = false, updatable = false)
    private StationInformation arrivalStationId;

    private Long cost;
    private String firstName;
    private String secondName;

    public Ticket() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StationInformation getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(StationInformation departureStationId) {
        this.departureStationId = departureStationId;
    }

    public StationInformation getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(StationInformation arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Ticket(StationInformation departureStationId,
                  StationInformation arrivalStationId,
                  Long cost, String firstName,
                  String secondName, Train train,
                  User user) {
        this.id = id;
        this.departureStationId = departureStationId;
        this.arrivalStationId = arrivalStationId;
        this.cost = cost;
        this.firstName = firstName;
        this.secondName = secondName;
        this.train = train;
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
