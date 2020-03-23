package com.RFB;

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
    
}
