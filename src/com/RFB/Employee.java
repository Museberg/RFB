package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    // Bliver brugt i metoderne writeToFile og readFromFile når et txt skal oprettes. fs vil enten være / eller \ alt efter om det er mac eller windows
    private static String fs = System.getProperty("file.separator"); // File separator
    private static String fileName = "src" + fs + "Database" + fs + "employee.txt";

    //Fields
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private int city_id;
    private String address;

    //Constructer
    public Employee(int id, String firstName, String lastName, int phoneNumber, int city_id, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city_id = city_id;
        this.address = address;
    }

    //Add employee method
    public static void addEmployee(ArrayList<Employee> employees) {
        Scanner console = new Scanner(System.in);
        System.out.println("Now adding a new employee");

        System.out.print("Type in an ID for the employee: ");
        int id = InputHelper.getIntFromUser();

        System.out.print("Type in first name: ");
        String firstName = console.next();

        System.out.print("Type in last name: ");
        String lastName = console.next();

        System.out.print("Type in telephone number: ");
        int phoneNumber = InputHelper.getPhoneNumberFromUser();

        System.out.print("Type in city id: ");
        int city_id = console.nextInt();
        console.nextLine();

        System.out.print("Type in address (street name and number): ");
        String address = console.nextLine();

        Employee tempEmployee = new Employee(id, firstName, lastName, phoneNumber, city_id, address);
        employees.add(tempEmployee);
    }

    //Read from file method
    public static ArrayList<Employee> readFromFile() throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        String line;
        ArrayList<Employee> employeeAL = new ArrayList<>();
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] lineInput = line.split(",");
            Employee tempEmployee = new Employee(Integer.parseInt(lineInput[0]), lineInput[1], lineInput[2], Integer.parseInt(lineInput[3]), Integer.parseInt(lineInput[4]), lineInput[5]);
            employeeAL.add(tempEmployee);
        }
        return employeeAL;
    }

    //Write to a file method
    public static void writeToFile(ArrayList<Employee> employees) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for (int i = 0; i < employees.size(); i++) {
            output.println(employees.get(i).toFile());
        }
    }

    //Getters & setters
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //toString method
    public String toString() {
        return "Employee ID: " + id + "\nName: " + firstName + " " + lastName;
    }

    //toFile Method (used in method writeToFile when saving to a file. Seperates each field with a comma)
    public String toFile() {
        return getId() + "," + getFirstName() + "," + getLastName() + "," + getPhoneNumber() + "," + getCity_id() + "," + getAddress();
    }


}
