package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Parent {
    // fields
    private int parentId;
    private String parentFirstName;
    private String parentLastName;
    private int parentPhoneNumber;


    // constructor
    public Parent(int parentId, String parentFirstName, String parentLastName, int parentPhoneNumber) {
        this.parentId = parentId;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.parentPhoneNumber = parentPhoneNumber;
    }

    // readFromFile()-method
    public static void readFromFile(ArrayList<Parent> parents) {
        try {
            // Creates a Scanner that scans a file
            Scanner input = new Scanner(new File("src/Database/parentList.txt"));
            String line;
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] lineInput = line.split(",");
                Parent parent = new Parent(Integer.parseInt(lineInput[0]), lineInput[1], lineInput[2], Integer.parseInt(lineInput[3]));
                parents.add(parent);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }

    }

    // writeToFile()-method
    public static void writeToFile(ArrayList<Parent> parents) throws FileNotFoundException {
        // Creates a PrintStream that prints to a file
        PrintStream parentOutput = new PrintStream(new File("src/Database/parentList.txt"));
        for (Parent p : parents) {
            parentOutput.println(p.toFile());
        }
    }

    // getters & setters
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public int getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(int parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    // toString()-method - Formats the variables into an easily readable String
    @Override
    public String toString() {
        return "Parent id: " + getParentId() +
                ", Parent Firstname: " + getParentFirstName() +
                ", Parent Lastname" + getParentLastName() +
                ", Parent Phonenumber: " + getParentPhoneNumber();
    }

    // toFile()-method
    public String toFile() {
        return (parentId + "," + parentFirstName + "," + parentLastName + "," + parentPhoneNumber);
    }

}