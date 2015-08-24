package edu.bsu.schedule.androidmodule.entity;

import edu.bsu.schedule.databasemodule.entity.Schedule;

import java.io.Serializable;
import java.util.List;

public class WeekScheduleWrapper implements Serializable{
    private static final long serialVersionUID = 123508312686538305L;

    private List<Schedule> scheduleList;

    private String errorMessage;

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
