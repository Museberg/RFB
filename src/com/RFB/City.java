package com.RFB;

public class City {
    private String cityName;
    private int zipCode;
    private int city_id;

    public City(String cityName, int phoneNumber, int city_id) {
        this.cityName = cityName;
        this.zipCode = phoneNumber;
        this.city_id = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int phoneNumber) {
        this.zipCode = phoneNumber;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
    public City readCity(){
        Scanner
        City city = new City();
        return city;
    }
}
