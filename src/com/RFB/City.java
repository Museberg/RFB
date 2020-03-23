package com.RFB;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static ArrayList<City> readCity(){
        ArrayList<City> cities = new ArrayList<>();
        Scanner input = new Scanner(new File("database/city.txt"));
        String line;
        while(input.hasNextLine()) {
            line = input.nextLine();
            String [] lineInput = line.split(",");
            City city = new City(lineInput[0], Integer.parseInt(lineInput[1]),Integer.parseInt(lineInput[2]));
        }
        return cities;
    }
}
