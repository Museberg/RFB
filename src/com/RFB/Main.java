package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        readFromFile();
        ArrayList<WorkSchedule> schedule = WorkSchedule.readFromFile();
        System.out.println(schedule);
        System.out.println("Hej");
        System.out.println(System.getProperty("file.separator"));
    }

    public static void readFromFile() throws FileNotFoundException {
        //ArrayList<Employee> employeeAL = new ArrayList<Employee>();
        //ArrayList<City> cities = City.readCity();
        //System.out.println(cities.get(0));
        //ArrayList<Parent> parents = Parent.readParent();
        /*
        ArrayList<Child> children = Child.readFromFile();
        ArrayList<WorkSchedule> schedules = WorkSchedule.readFromFile();
        ArrayList<Room> rooms = Room.readFromFile();
        ArrayList<Household> households = Household.readFromFile();
        ArrayList<Employee> employeeAL = Employee.readEmployee();
         */
        //ArrayList<WorkSchedule> schedule = WorkSchedule.readFromFile();
        //System.out.println(schedule.get(0));
    }
}
