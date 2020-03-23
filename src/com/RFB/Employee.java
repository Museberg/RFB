package com.RFB;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private int city_id;
    private String address;

    public Employee(String firstName, String lastName, int phoneNumber, int city_id, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city_id = city_id;
        this.address = address;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void addEmployee(ArrayList<Employee> employeeAL){
        Scanner console = new Scanner(System.in);
        System.out.println("Now adding a new employee");

        System.out.println("Type in first name");
        String firstName = console.next();

        System.out.println("Type in last name");
        String lastName = console.next();

        System.out.println("Type in telephone number");
        int phoneNumber = console.nextInt();

        System.out.println("Type in city id");
        int city_id = console.nextInt();
        console.nextLine();

        System.out.println("Type in address (street name and number)");
        String address = console.nextLine();

        Employee tempEmployee = new Employee(firstName, lastName, phoneNumber, city_id, address);
        employeeAL.add(tempEmployee);



    }
}
