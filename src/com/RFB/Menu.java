package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static void printOptions() {
        System.out.printf("%d - Tilføj stue%n", 1);
        System.out.printf("%d - Indmeld barn%n", 2);
        System.out.printf("%d - Tilføj husstand%n", 3);
        System.out.printf("%d - Tilføj medarbejder%n", 4);
        System.out.printf("%d - Luk program og gem%n", 0);
        System.out.print("Indtast dit valg: ");
    }

    public static void startMenu() {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee.readFromFile(employees);
        ArrayList<City> cities = new ArrayList<>();
        City.readFromFile(cities);
        ArrayList<Parent> parents = new ArrayList<>();
        Parent.readFromFile(parents);
        ArrayList<Child> children = new ArrayList<>();
        Child.readFromFile(children);
        ArrayList<WorkSchedule> schedules = new ArrayList<>();
        WorkSchedule.readFromFile(schedules);
        ArrayList<Room> rooms = new ArrayList<>();
        Room.readFromFile(rooms);
        ArrayList<Household> households = new ArrayList<>();
        Household.readFromFile(households);

        int option = -1;
        login();

        while (option != 0) {
            printOptions();
            option = InputHelper.getOptionFromUser(0, 4);

            switch (option) {
                case 1: // Add room
                    System.out.println("Endnu ikke implementeret!");
                    break;
                case 2: // Add child
                    Child child = Child.createChild(parents, rooms, households, children);
                    if(child != null){ // If null, creation was cancelled due to no available rooms
                        children.add(child);
                    }
                    break;
                case 3:
                    System.out.println("Endnu ikke implementeret!");
                    break;
                case 4:
                    Employee.addEmployee(employees);
                    break;
                case 0:
                    Employee.writeToFile(employees);
                    City.writeToFile(cities);
                    Parent.writeToFile(parents);
                    Child.writeToFile(children);
                    WorkSchedule.writeToFile(schedules);
                    Room.writeToFile(rooms);
                    Household.writeToFile(households);
                    System.out.println("Alt dit arbejde er gemt");
                    break;
            }
        }
    }

    private static void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast venligst brugernavn (admin)");
        String username = input.next();
        System.out.println("Indtast venligts kodeord (admin)");
        String password = input.next();

        while (!username.equals("admin") || !password.equals("admin")) {
            System.out.println("Brugernavn eller kodeord forkert. Prøv venligst igen");
            System.out.println("Indtast venligst brugernavn");
            username = input.next();
            System.out.println("Indtast venligst kodeord");
            password = input.next();
        }
    }

}
