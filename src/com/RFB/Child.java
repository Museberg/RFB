package com.RFB;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Child {
    private int id; // Primary key
    private String firstName;
    private String lastName;
    private int parent_id; // Foreign key
    private int room_id; // Foreign key
    private int household_id; // Foreign key

    // Used for file handling
    private static String fileName = "src/Database/children.txt";


    public Child(int id, String firstName, String lastName, int parent_id, int room_id, int household_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parent_id = parent_id;
        this.room_id = room_id;
        this.household_id = household_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getHousehold_id() {
        return household_id;
    }

    public void setHousehold_id(int household_id) {
        this.household_id = household_id;
    }

    // Saving all children to file
    public static void writeToFile(ArrayList<Child> children) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for(Child child : children){
            output.println(child.toFile());
        }
    }

    // Reads all children from file and returns them in an arraylist
    public static ArrayList<Child> readFromFile() throws FileNotFoundException {
        ArrayList<Child> children = new ArrayList<>();
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNextLine()){
            Scanner lineScan = new Scanner(scan.nextLine());
            lineScan.useDelimiter(", ");
            Child child = new Child(lineScan.nextInt(), lineScan.next(), lineScan.next(), lineScan.nextInt(), lineScan.nextInt(), lineScan.nextInt());
            children.add(child);
        }
        return children;
    }

    public String toString(){
        return String.format("ID: %d%nFirst name: %s%nLast name: %s%nParent ID: %d%nRoom ID: %d%nHousehold ID: %d",
                id, firstName, lastName, parent_id, room_id, household_id);
    }

    // Returns the child as a string with each field separated by a comma
    private String toFile(){
        return String.format("%d, %s, %s, %d, %d, %d", id, firstName, lastName, parent_id, room_id, household_id);
    }
}
