package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private int id; // Primary key
    private String roomName;

    // Used for database
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "room.txt";

    public Room(int id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }

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

    public static void writeToFile(ArrayList<Room> rooms) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for(Room room : rooms){
            output.println(room.toFile());
        }
    }

    public static ArrayList<Room> readFromFile() throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<>();
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNextLine()){
            Scanner lineScan = new Scanner(scan.nextLine());
            lineScan.useDelimiter(", ");
            Room room = new Room(lineScan.nextInt(), lineScan.next());
            rooms.add(room);
        }
        return rooms;
    }

    // Used to save the room to a file
    public String toFile(){
        return String.format("%d, %s", id, roomName);
    }

    public int getChildrenInRoom(ArrayList<Child> children){
        int childrenInRoom = 0;
        for(Child child : children){
            if(child.getRoom_id() == this.id){
                childrenInRoom++;
            }
        }
        return childrenInRoom;
    }

    @Override
    public String toString(){
        return String.format("ID: %s%nRoom name: %s", id, roomName);
    }
}
