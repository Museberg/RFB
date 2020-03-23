package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Parent {
    private int parentId;
    private String parentFirstName;
    private String parentLastName;
    private int parentPhoneNumber;


    public Parent(int parentId, String parentFirstName, String parentLastName, int parentPhoneNumber) {
        this.parentId = parentId;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.parentPhoneNumber = parentPhoneNumber;

    }

    public static ArrayList<Parent> readParent() throws FileNotFoundException {
        ArrayList<Parent> parents = new ArrayList<>();
        Scanner input = new Scanner(new File("Database/parentList.txt"));
        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] lineInput = line.split(",");
            Parent parent = new Parent(Integer.parseInt(lineInput[0]), lineInput[1], lineInput[2], Integer.parseInt(lineInput[3]));
            parents.add(parent);
        }
        return parents;
    }

    public static ArrayList<Parent> writeParent() throws FileNotFoundException {
        ArrayList<Parent> parents = new ArrayList<>();
        PrintStream parentOutput = new PrintStream(new File("Database/parentList.txt"));
        for (Parent p : parents) {
            parentOutput.println(p.toFile());
        }
        return parents;
    }

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

    @Override
    public String toString() {
        return "Parent: Parent id: " + getParentId() +
                ", Parent Firstname: " + getParentFirstName() +
                ", Parent Lastname" + getParentLastName() +
                ", Parent Phonenumber: " + getParentPhoneNumber();
    }

    public String toFile() {
        return (parentId + "," + parentFirstName + "," + parentLastName + "," + parentPhoneNumber);
    }

}
