package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    // Used for database
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "room.txt";
    private int id; // Primary key
    private String roomName;

    public Room(int id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }

    // Writes each room to a file
    public static void writeToFile(ArrayList<Room> rooms) {
        try {
            PrintStream output = new PrintStream(new File(fileName));
            for (Room room : rooms) {
                output.println(room.toFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Reads all rooms from the file and returns them as an arraylist
    public static void readFromFile(ArrayList<Room> rooms) {
        try {
            Scanner scan = new Scanner(new File(fileName));
            // Iterates through each line and parses the tokens
            while (scan.hasNextLine()) {
                Scanner lineScan = new Scanner(scan.nextLine());
                lineScan.useDelimiter(", ");
                Room room = new Room(lineScan.nextInt(), lineScan.next());
                rooms.add(room);
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    // Used to save the room to a file
    public String toFile() {
        return String.format("%d, %s", id, roomName);
    }

    // Iterates through all children and returns the amount of children in the room this method was called on
    public int getChildrenInRoom(ArrayList<Child> children) {
        int childrenInRoom = 0;
        for (Child child : children) {
            if (child.getRoom_id() == this.id) {
                childrenInRoom++;
            }
        }
        return childrenInRoom;
    }

    @Override
    public String toString() {
        return String.format("ID: %s%nRoom name: %s", id, roomName);
    }
}
