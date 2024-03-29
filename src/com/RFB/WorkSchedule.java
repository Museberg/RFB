package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

// Fields
public class WorkSchedule {
    private int workSchedule_id;
    private int workSchedule_week;
    private String workSchedule_day;
    private String workSchedule_hourStart;
    private String workSchedule_hourEnd;

    // Constructor
    public WorkSchedule(int workSchedule_id, int workSchedule_week, String workSchedule_day, String workSchedule_hourStart, String workSchedule_hourEnd) {
        this.workSchedule_id = workSchedule_id;
        this.workSchedule_week = workSchedule_week;
        this.workSchedule_day = workSchedule_day;
        this.workSchedule_hourStart = workSchedule_hourStart;
        this.workSchedule_hourEnd = workSchedule_hourEnd;
    }

    // Reads every line in txt workschedule, and adds to arraylist
    public static void readFromFile(ArrayList<WorkSchedule> schedules) {
        try {
            String bs = System.getProperty("file.separator"); // separates with either / or \ depending on what os its on
            Scanner input = new Scanner(new File("src" + bs + "Database" + bs + "workschedule.txt"));
            String line;
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] lineInput = line.split(",");  // Splits at every komma, and ads ever spot as a spot in the string array
                WorkSchedule schedule = new WorkSchedule(Integer.parseInt(lineInput[0]), Integer.parseInt(lineInput[1]), lineInput[2], lineInput[3], lineInput[4]);
                schedules.add(schedule);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Saves/writes the objects in the arraylist to the text file, by traversing through it
    public static void writeToFile(ArrayList<WorkSchedule> schedules) {
        try {
            String bs = System.getProperty("file.separator");
            PrintStream output = new PrintStream(new File("src" + bs + "Database" + bs + "workschedule.txt"));
            for (int i = 0; i < schedules.size(); i++) {  // prints every array element into the txt file, using the toFile method
                output.println(schedules.get(i).toFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Error]: File was not found!");
        } catch (Exception e) {
            System.out.println("[Error]: An unknown error has occurred!");
        }
    }

    // Getters & Setters
    public int getWorkSchedule_id() {
        return workSchedule_id;
    }

    public void setWorkSchedule_id(int workSchedule_id) {
        this.workSchedule_id = workSchedule_id;
    }

    public int getWorkSchedule_week() {
        return workSchedule_week;
    }

    public void setWorkSchedule_week(int workSchedule_week) {
        this.workSchedule_week = workSchedule_week;
    }

    public String getWorkSchedule_day() {
        return workSchedule_day;
    }

    public void setWorkSchedule_day(String workSchedule_day) {
        this.workSchedule_day = workSchedule_day;
    }

    public String getWorkSchedule_hourStart() {
        return workSchedule_hourStart;
    }

    public void setWorkSchedule_hourStart(String workSchedule_hourStart) {
        this.workSchedule_hourStart = workSchedule_hourStart;
    }

    public String getWorkSchedule_hourEnd() {
        return workSchedule_hourEnd;
    }

    public void setWorkSchedule_hourEnd(String workSchedule_hourEnd) {
        this.workSchedule_hourEnd = workSchedule_hourEnd;
    }

    // Format of how it is printed to the txt file
    public String toFile() {
        return this.workSchedule_id + "," + this.workSchedule_week + "," + this.workSchedule_day + "," + this.workSchedule_hourStart + "," + this.workSchedule_hourEnd;
    }

    // toString override
    @Override
    public String toString() {
        return String.format("ID: %d%nWeek: %d%nDay: %s%nShift start: %s%nShift end: %s%n",
                workSchedule_id, workSchedule_week, workSchedule_day, workSchedule_hourStart, workSchedule_hourEnd);
    }
}
