package edu.bsu.schedule.androidmodule.entity;

import edu.bsu.schedule.databasemodule.entity.Schedule;

import java.io.Serializable;

public class DayScheduleWrapper implements Serializable {
    private static final long serialVersionUID = 223508312686538305L;

    private Schedule schedule;

    private String errorMessage;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
