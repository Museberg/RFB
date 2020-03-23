package com.RFB;

public class Household {
    private int id; // Primary key
    private String address;
    private int city_id; // Foreign key

    public Household(int id, String address, int city_id) {
        this.id = id;
        this.address = address;
        this.city_id = city_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
}
