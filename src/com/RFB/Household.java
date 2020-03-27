package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Household {
    // Used for database
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "household.txt";
    private int id; // Primary key
    private String address;
    private int city_id; // Foreign key


    // Constructor
    public Household(int id, String address, int city_id) {
        this.id = id;
        this.address = address;
        this.city_id = city_id;
    }

    // Reads all the households from file
    public static void readFromFile(ArrayList<Household> households) {
        try {
            Scanner scan = new Scanner(new File(fileName));
            // Iterates thorugh all the lines and parses the tokens
            while (scan.hasNextLine()) {
                Scanner lineScan = new Scanner(scan.nextLine());
                lineScan.useDelimiter(", ");
                Household household = new Household(lineScan.nextInt(), lineScan.next(), lineScan.nextInt());
                households.add(household);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Writes all the households to file on a separate line
    public static void writeToFile(ArrayList<Household> households) {
        try {
            PrintStream output = new PrintStream(new File(fileName));
            for (Household household : households) {
                output.println(household.toFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Getters and setters
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

    // Used for saving household to file
    public String toFile() {
        return String.format("%d, %s, %d", id, address, city_id);
    }
}
