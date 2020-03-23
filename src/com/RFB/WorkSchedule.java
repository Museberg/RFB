package com.RFB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkSchedule {
    private int workSchedule_id;
    private int workSchedule_week;
    private String workSchedule_day;
    private double workSchedule_hourStart;
    private double workSchedule_hourEnd;

    public WorkSchedule(int workSchedule_id, int workSchedule_week, String workSchedule_day, double workSchedule_hourStart, double workSchedule_hourEnd) {
        this.workSchedule_id = workSchedule_id;
        this.workSchedule_week = workSchedule_week;
        this.workSchedule_day = workSchedule_day;
        this.workSchedule_hourStart = workSchedule_hourStart;
        this.workSchedule_hourEnd = workSchedule_hourEnd;
    }

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

    public double getWorkSchedule_hourStart() {
        return workSchedule_hourStart;
    }

    public void setWorkSchedule_hourStart(double workSchedule_hourStart) {
        this.workSchedule_hourStart = workSchedule_hourStart;
    }

    public double getWorkSchedule_hourEnd() {
        return workSchedule_hourEnd;
    }

    public void setWorkSchedule_hourEnd(double workSchedule_hourEnd) {
        this.workSchedule_hourEnd = workSchedule_hourEnd;
    }

    public static ArrayList<WorkSchedule> readFromFile() throws FileNotFoundException {
        ArrayList<WorkSchedule> schedules = new ArrayList<>();
        Scanner input = new Scanner(new File("database/workschedule.txt"));
        String line;
        while(input.hasNextLine()) {
            line = input.nextLine();
            String [] lineInput = line.split(",");
            WorkSchedule schedule = new WorkSchedule(Integer.parseInt(lineInput[0]), Integer.parseInt(lineInput[1]), lineInput[2], Double.parseDouble(lineInput[3]), Double.parseDouble(lineInput[4]));
            schedules.add(schedule);
        }
        return schedules;
    }

    public String toFile() {
        return this.workSchedule_id + ", " + this.workSchedule_week + ", " + this.workSchedule_day + ", " + this.workSchedule_hourStart + ", " + this.workSchedule_hourEnd;
    }

    public static void writeToFile(ArrayList<WorkSchedule> schedules) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("database/workschedule.txt"));
            for (int i = 0; i < schedules.size(); i++) {
                output.println(schedules.get(i).toFile());
            }
    }
}
