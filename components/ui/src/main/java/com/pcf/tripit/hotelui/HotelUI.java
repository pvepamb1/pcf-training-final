package com.pcf.tripit.hotelui;

public class HotelUI {

    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String city;
    private int capacity;
    private double price;
    private String date;

    public HotelUI() {
    }

    public HotelUI(String name, String address, String city, int capacity, double price,String date) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.date= date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

