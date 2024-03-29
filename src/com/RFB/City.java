package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class City {
    private String cityName;
    private int zipCode;
    private int city_id;

    // Constructor
    public City(String cityName, int zipCode, int city_id) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.city_id = city_id;
    }

    // Method that reads from city.txt and populates the arrayList with City objects
    public static void readFromFile(ArrayList<City> cities) {
        try {
            Scanner input = new Scanner(new File("src/Database/city.txt"));
            String line;
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] lineInput = line.split(",");
                City city = new City(lineInput[0], Integer.parseInt(lineInput[1]), Integer.parseInt(lineInput[2]));
                cities.add(city);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Method for saving all City objects to city.txt
    public static void writeToFile(ArrayList<City> cities) {
        try {
            PrintStream output = new PrintStream(new File("src/Database/city.txt"));
            for (int i = 0; i < cities.size(); i++) {
                output.println(cities.get(i).toFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    //  Getters and Setters
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

    // toFile method is used by writeToFile for ease of use when saving
    public String toFile() {
        return getCityName() + "," + getZipCode() + "," + getCity_id();
    }

    // a toString method
    @Override
    public String toString() {
        return "ID: " + city_id + "\nCity: " + cityName + ", " + zipCode;
    }
}
