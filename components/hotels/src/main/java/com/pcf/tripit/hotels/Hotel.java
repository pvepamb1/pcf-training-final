package com.pcf.tripit.hotels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hotel {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private String name;
    private String address;
    private String city;
    private int capacity;
    private double price;

    public Hotel() {
    }

    public Hotel(long id,String name, String address, String city, int capacity, double price) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.address, this.city);
    }
}


