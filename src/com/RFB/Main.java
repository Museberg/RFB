package com.RFB;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        readFromFile();
        System.out.println("Hej");
    }

    public static void readFromFile(){
        //ArrayList<Employee> employeeAL = new ArrayList<Employee>();
        ArrayList<City> cities = City.readCity();
        ArrayList<Parent> parents = Parent.readParent();
        /*
        ArrayList<Child> children = Child.readFromFile();
        ArrayList<WorkSchedule> schedules = WorkSchedule.readFromFile();
        ArrayList<Room> rooms = Room.readFromFile();
        ArrayList<Household> households = Household.readFromFile();
        ArrayList<Employee> employeeAL = Employee.readEmployee();
         */
    }
}
