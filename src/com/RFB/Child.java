package com.RFB;

public class Child {
    private int id; // Primary key
    private String firstName;
    private String lastName;
    private int parent_id; // Foreign key
    private int room_id; // Foreign key
    private int household_id; // Foreign key


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
}
