package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<City> cities = new ArrayList<>();
        ArrayList<Parent> parents = new ArrayList<>();
        ArrayList<Child> children = new ArrayList<>();
        ArrayList<WorkSchedule> schedules = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Household> households = new ArrayList<>();
        readFromFile(employees, cities, parents, children, schedules, rooms, households);
        writeToFile(employees, cities, parents, children, schedules, rooms, households);
        System.out.println("Main parents size " + parents.size());
    }

    public static void readFromFile(ArrayList<Employee> employees, ArrayList<City> cities, ArrayList<Parent> parents, ArrayList<Child> children, ArrayList<WorkSchedule> schedules, ArrayList<Room> rooms, ArrayList<Household> households) throws FileNotFoundException {

//      employees = Employee.readFromFile();
        cities = City.readFromFile();
        parents = Parent.readFromFile();
        children = Child.readFromFile();
//      schedules = WorkSchedule.readFromFile();
        rooms = Room.readFromFile();
        households = Household.readFromFile();
//      employeeAL = Employee.readEmployee();
        System.out.println("Read from file parents size " + parents.size());
        //Menu.startMenu(employees, cities, parents, children, schedules, rooms, households);

    }

    public static void writeToFile(ArrayList<Employee> employees, ArrayList<City> cities, ArrayList<Parent> parents, ArrayList<Child> children, ArrayList<WorkSchedule> schedules, ArrayList<Room> rooms, ArrayList<Household> households) throws FileNotFoundException {
        /*
        Employee.writeToFile(employees);
        City.writeToFile(cities);
        Parent.writeToFile(parents);
        Child.writeToFile(children);
        WorkSchedule.writeToFile(schedules);
        Room.writeToFile(rooms);
        Household.writeToFile(households);
         */
    }
}
