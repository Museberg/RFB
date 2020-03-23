package com.RFB;

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
}
