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

    public Household(int id, String address, int city_id) {
        this.id = id;
        this.address = address;
        this.city_id = city_id;
    }

    public static ArrayList<Household> readFromFile() throws FileNotFoundException {
        ArrayList<Household> households = new ArrayList<>();
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNextLine()) {
            Scanner lineScan = new Scanner(scan.nextLine());
            lineScan.useDelimiter(", ");
            Household household = new Household(lineScan.nextInt(), lineScan.next(), lineScan.nextInt());
            households.add(household);
        }
        return households;
    }

    public static void writeToFile(ArrayList<Household> households) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for (Household household : households) {
            output.println(household.toFile());
        }
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

    // Used for saving household to file
    public String toFile() {
        return String.format("%d, %s, %d", id, address, city_id);
    }
}
