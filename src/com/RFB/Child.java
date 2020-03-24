package com.RFB;

import java.io.*;
import java.sql.SQLOutput;
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
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "children.txt";


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

    public static Child createChild(ArrayList<Parent> parents, ArrayList<Room> rooms, ArrayList<Household> households){
        System.out.println("To create a child, we need some information. Please enter the required information when prompted");
        System.out.println("What is the ID of the child?");
        int id = InputHelper.getIntFromUser();

        System.out.println("What is the first name of the child?");
        String firstName = InputHelper.getStringFromUser("First name");

        System.out.println("What is the last name of the child?");
        String lastName = InputHelper.getStringFromUser("Last name");

        System.out.println("Who is the child's parent? (primary contact person)");
        System.out.printf("%d - Select from registered parents%n%d - Create a new parent%n", 1, 2);
        int parentID = -1;
        int option = InputHelper.getOptionFromUser(1, 2);
        if(option == 1){ // Select from already registered parents
            for(int i = 0; i < parents.size(); i++){
                String fs = parents.get(i).getParentFirstName();
                String ls = parents.get(i).getParentLastName();
                System.out.printf("%d - %s %s%n", i+1, fs, ls); // Adding 1 to index to look nice
            }
            System.out.println("Please select a parent");
            option = InputHelper.getOptionFromUser(1, parents.size() + 1);
            parentID = parents.get(option - 1).getParentId(); // Subtracting 1 from the index
        }
        else if(option == 2){ // Register new parent
            System.out.println("Not yet implemented! Selecting parent with ID 1");
            parentID = 1;
        }

        System.out.println("What room should the child be placed in?");
        for(int i = 0; i < rooms.size(); i++){
            System.out.printf("%d - %s%n", i+1, rooms.get(i).getRoomName());
        }
        System.out.println("Please select a room");
        option = InputHelper.getOptionFromUser(1, rooms.size() + 1);
        int roomID = rooms.get(option - 1).getId();

        System.out.println("In which household does the child live in?");
        System.out.printf("%d - Select from existing households%n%d - Create new household%n", 1, 2);
        int householdID = -1;
        option = InputHelper.getOptionFromUser(1, 2);
        if(option == 1){ // Select from existing households
            for(int i = 0; i < households.size(); i++){
                System.out.printf("%d - %s%n", i+1, households.get(i).getAddress());
            }
            System.out.println("Please select a household");
            option = InputHelper.getOptionFromUser(1, households.size() + 1);
            householdID = households.get(option - 1).getId();
        }
        else if(option == 2){ // Creating new household
            System.out.println("Not yet implemented! Selecting household with ID 1");
            householdID = 1;
        }

        return new Child(id, firstName, lastName, parentID, roomID, householdID);
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

    @Override
    public String toString(){
        return String.format("ID: %d%nFirst name: %s%nLast name: %s%nParent ID: %d%nRoom ID: %d%nHousehold ID: %d",
                id, firstName, lastName, parent_id, room_id, household_id);
    }

    // Returns the child as a string with each field separated by a comma
    private String toFile(){
        return String.format("%d, %s, %s, %d, %d, %d", id, firstName, lastName, parent_id, room_id, household_id);
    }
}
