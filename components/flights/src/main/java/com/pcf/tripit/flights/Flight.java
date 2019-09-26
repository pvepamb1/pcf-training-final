package com.pcf.tripit.flights;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private String airlinesName;
    private String flightNumber;
    private Date arrivalTime;
    private Date departureTime;
    private String destination;
    private String source;
    private int cost;
    private int ticketsLeft;

    public Flight() {
    }

    public Flight(String airlinesName, String flightNumber, Date arrivalTime, Date departureTime, String destination, String source, int cost, int ticketsLeft) {
        this.airlinesName = airlinesName;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.destination = destination;
        this.source = source;
        this.cost = cost;
        this.ticketsLeft = ticketsLeft;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirlinesName() {
        return airlinesName;
    }

    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.airlinesName, this.flightNumber, this.source, this.destination, this.departureTime);
    }
}
