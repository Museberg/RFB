package com.RFB;

public class City {
    private String cityName;
    private int phoneNumber;
    private int city_id;

    public City(String cityName, int phoneNumber, int city_id) {
        this.cityName = cityName;
        this.phoneNumber = phoneNumber;
        this.city_id = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
    public void readCity(){

    }
}
