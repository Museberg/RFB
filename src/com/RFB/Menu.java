package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static void printOptions(){
        System.out.printf("%d - Tilføj stue%n", 1);
        System.out.printf("%d - Indmeld barn%n", 2);
        System.out.printf("%d - Tilføj husstand%n", 3);
        System.out.printf("%d - Luk program og gem%n", 0);
        System.out.println("Indtast dit valg: ");
    }

    public static void startMenu() throws FileNotFoundException {
        ArrayList<Employee> employees = Employee.readFromFile();
        ArrayList<City> cities = City.readFromFile();
        ArrayList<Parent> parents = Parent.readFromFile();
        ArrayList<Child> children = Child.readFromFile();
        ArrayList<WorkSchedule> schedules = WorkSchedule.readFromFile();
        ArrayList<Room> rooms = Room.readFromFile();
        ArrayList<Household> households = Household.readFromFile();

        int option = -1;
        login();

        while(option != 0){
            printOptions();
            option = InputHelper.getOptionFromUser(0, 3);

            switch (option){
                case 1: // Add room
                    System.out.println("Endnu ikke implementeret!");
                    break;
                case 2: // Add child
                    Child child = Child.createChild(parents, rooms, households);
                    System.out.println(child);
                    break;
                case 3:
                    System.out.println("Endnu ikke implementeret!");
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

    private static void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast venligst brugernavn");
        String username = input.next();
        System.out.println("Indtast venligts kodeord");
        String password = input.next();

        while(!username.equals("admin") || !password.equals("admin")){
            System.out.println("Brugernavn eller kodeord forkert. Prøv venligst igen");
            System.out.println("Indtast venligst brugernavn");
            username = input.next();
            System.out.println("Indtast venligts kodeord");
            password = input.next();
        }
    }

}
