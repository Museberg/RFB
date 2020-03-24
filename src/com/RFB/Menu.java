package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu {

    private static void printOptions(){
        System.out.printf("%d - Add room%n", 1);
        System.out.printf("%d - Add child%n", 2);
        System.out.printf("%d - Add household%n", 3);
        System.out.printf("%d - Exit menu%n", 0);
    }

    public static void startMenu() throws FileNotFoundException {
        ArrayList<Employee> employees = Employee.readFromFile();
        ArrayList<City> cities = City.readFromFile();
        ArrayList<Parent> parents = Parent.readFromFile();
        ArrayList<Child> children = Child.readFromFile();
        ArrayList<WorkSchedule> schedules = WorkSchedule.readFromFile();
        ArrayList<Room> rooms = Room.readFromFile();
        ArrayList<Household> households = Household.readFromFile();

        printOptions();
        int option = InputHelper.getOptionFromUser(0, 3);

        switch (option){
            case 1: // Add room
                break;
            case 2: // Add child
                Child child = Child.createChild(parents, rooms, households);
                System.out.println(child);
                break;
            case 0:
                Employee.writeToFile(employees);
                City.writeToFile(cities);
                Parent.writeToFile(parents);
                Child.writeToFile(children);
                WorkSchedule.writeToFile(schedules);
                Room.writeToFile(rooms);
                Household.writeToFile(households);
                System.out.println("Goodbye");
                break;
        }
    }

}
