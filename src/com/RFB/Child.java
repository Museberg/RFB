package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Child {
    // Used for file handling
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "children.txt";
    private int id; // Primary key
    private String firstName;
    private String lastName;
    private int parent_id; // Foreign key
    private int room_id; // Foreign key
    private int household_id; // Foreign key


    // Constructor
    public Child(int id, String firstName, String lastName, int parent_id, int room_id, int household_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parent_id = parent_id;
        this.room_id = room_id;
        this.household_id = household_id;
    }
    // Getters and setters
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

    // Lets the user create a child by prompting them for the required information
    public static Child createChild(ArrayList<Parent> parents, ArrayList<Room> rooms, ArrayList<Household> households, ArrayList<Child> children) {
        System.out.println("For at indmelde et barn, skal vi bruge noget information. Indtast venligst oplysninger når du bliver bedt om det");
        int id = getLastID(children) + 1;

        System.out.println("Hvad er barnets fornavn?");
        String firstName = InputHelper.getStringFromUser("First name");

        System.out.println("Hvad er barnets efternavn?");
        String lastName = InputHelper.getStringFromUser("Last name");

        System.out.println("Hvem er barnets forælder? (primær kontaktperson");
        System.out.printf("%d - Vælg fra eksisterende forældre%n%d - Opret ny forælder%n", 1, 2);
        int parentID = -1;
        int option = InputHelper.getOptionFromUser(1, 2);
        if (option == 1) { // Select from already registered parents
            for (int i = 0; i < parents.size(); i++) {
                String fs = parents.get(i).getParentFirstName();
                String ls = parents.get(i).getParentLastName();
                System.out.printf("%d - %s %s%n", i + 1, fs, ls); // Adding 1 to index to look nice
            }
            System.out.println("Vælg venligst en forælder");
            option = InputHelper.getOptionFromUser(1, parents.size() + 1);
            parentID = parents.get(option - 1).getParentId(); // Subtracting 1 from the index
        } else if (option == 2) { // Register new parent
            System.out.println("Endnu ikke implementeret. Vælger forælder med ID 1");
            parentID = 1;
        }

        System.out.println("Hvilken stue skal barnet gå på?");
        int roomID = 0;
        ArrayList<Room> availableRooms = getAvailableRooms(rooms, children, 2);
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, availableRooms.get(i).getRoomName());
        }
        if (availableRooms.size() == 0) {
            System.out.println("Der er ingen stuer tilgængelige med ledige pladser. Ønsker du at sætte barnet på venteliste?");
            System.out.printf("%d - Ja%n%d - Nej", 1, 2);
            option = InputHelper.getOptionFromUser(1, 2);
            if(option == 1){ // Adding child to waitlist
                roomID = 0;
            }
            else{ // Aborting creation of child
                System.out.println("Afbryder indmelding af barn");
                return null;
            }
        } else if (availableRooms.size() > 0) {
            System.out.println("Vælg venligst en stue");
            option = InputHelper.getOptionFromUser(1, availableRooms.size() + 1);
            roomID = availableRooms.get(option - 1).getId();
        }

        System.out.println("I hvilken husstand bor barnet?");
        System.out.printf("%d - Vælg fra eksisterende husstande%n%d - Lav en ny husstand%n", 1, 2);
        int householdID = -1;
        option = InputHelper.getOptionFromUser(1, 2);
        if (option == 1) { // Select from existing households
            for (int i = 0; i < households.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, households.get(i).getAddress());
            }
            System.out.println("Vælg venligst en husstand");
            option = InputHelper.getOptionFromUser(1, households.size() + 1);
            householdID = households.get(option - 1).getId();
        } else if (option == 2) { // Creating new household
            System.out.println("Endnu ikke implementeret. Vælger husstand med ID 1");
            householdID = 1;
        }

        return new Child(id, firstName, lastName, parentID, roomID, householdID);
    }

    // Iterates through each room and returns a list of rooms with at least 1 spot available.
    // Also does not return waiting list room
    public static ArrayList<Room> getAvailableRooms(ArrayList<Room> rooms, ArrayList<Child> children, int roomSize) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getChildrenInRoom(children) < roomSize && room.getId() != 0) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Saving all children to file
    public static void writeToFile(ArrayList<Child> children) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for (Child child : children) {
            output.println(child.toFile());
        }
    }

    // Reads all children from file and returns them in an arraylist
    public static void readFromFile(ArrayList<Child> children) {
        try {
            Scanner scan = new Scanner(new File(fileName));
            // Iterates through each line and parses the tokens
            while (scan.hasNextLine()) {
                Scanner lineScan = new Scanner(scan.nextLine());
                lineScan.useDelimiter(", ");
                Child child = new Child(lineScan.nextInt(), lineScan.next(), lineScan.next(), lineScan.nextInt(), lineScan.nextInt(), lineScan.nextInt());
                children.add(child);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Returns the last issued ID for child
    private static int getLastID(ArrayList<Child> children) {
        return children.get(children.size() - 1).getId();
    }

    @Override
    public String toString() {
        return String.format("ID: %d%nFornavn: %s%nEfternavn: %s%nForælder ID: %d%Stue ID: %d%Husstand ID: %d",
                id, firstName, lastName, parent_id, room_id, household_id);
    }

    // Returns the child as a string with each field separated by a comma
    private String toFile() {
        return String.format("%d, %s, %s, %d, %d, %d", id, firstName, lastName, parent_id, room_id, household_id);
    }
}
