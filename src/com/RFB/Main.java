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
        System.out.println("HEJ");
    }
    

    public static void readFromFile(ArrayList<Employee> employees, ArrayList<City> cities, ArrayList<Parent> parents, ArrayList<Child> children, ArrayList<WorkSchedule> schedules, ArrayList<Room> rooms, ArrayList<Household> households) throws FileNotFoundException {
        /*
        ArrayList<Employee> employees = Employee.readEmployee();
        ArrayList<City> cities = City.readCity();
        ArrayList<Parent> parents = Parent.readParent();
        ArrayList<Child> children = Child.readFromFile();
        ArrayList<WorkSchedule> schedules = WorkSchedule.readFromFile();
        ArrayList<Room> rooms = Room.readFromFile();
        ArrayList<Household> households = Household.readFromFile();
        ArrayList<Employee> employeeAL = Employee.readEmployee();
         */
    }

    public static void writeToFile(ArrayList<Employee> employees, ArrayList<City> cities, ArrayList<Parent> parents, ArrayList<Child> children, ArrayList<WorkSchedule> schedules, ArrayList<Room> rooms, ArrayList<Household> households) throws FileNotFoundException {
        /*
        Employee.writeEmployee(employees);
        City.writeCity(cities);
        Parent.writeParent(parents);
        Child.writeToFile(children);
        WorkSchedule.writeToFile(schedules);
        Room.writeToFile(rooms);
        Household.writeToFile(households);
         */
    }
}
