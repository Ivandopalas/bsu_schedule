package edu.bsu.schedule.androidmodule.entity;

import edu.bsu.schedule.databasemodule.entity.vo.ScheduleVO;

import java.io.Serializable;
import java.util.List;

public class WeekScheduleWrapper implements Serializable{
    private static final long serialVersionUID = 123508312686538305L;

    private List<ScheduleVO> scheduleVOList;

    private String errorMessage;

    public List<ScheduleVO> getScheduleList() {
        return scheduleVOList;
    }

    public void setScheduleList(List<ScheduleVO> scheduleList) {
        this.scheduleVOList = scheduleList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
