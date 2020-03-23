package com.RFB;

import java.util.ArrayList;

public class Menu {

    private static void printOptions(){
        System.out.printf("%d - Add room%n", 1);
        System.out.printf("%d - Add child%n", 2);
        System.out.printf("%d - Add household%n", 3);
        System.out.printf("%d - Exit menu%n", 0);
    }

    public static void startMenu(ArrayList<Employee> employees, ArrayList<City> cities, ArrayList<Parent> parents, ArrayList<Child> children,
                                 ArrayList<WorkSchedule> schedules, ArrayList<Room> rooms, ArrayList<Household> households){
        printOptions();
        int option = InputHelper.getOptionFromUser(0, 3);

        switch (option){
            case 1: // Add room
                break;
            case 2: // Add child
                Child child = Child.createChild(parents, rooms, households);
                System.out.println(child);
                break;
        }
    }

}
