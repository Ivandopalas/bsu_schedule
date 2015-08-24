package edu.bsu.schedule.databasemodule.service;

import edu.bsu.schedule.databasemodule.entity.Course;
import edu.bsu.schedule.databasemodule.entity.Group;
import edu.bsu.schedule.databasemodule.entity.Schedule;

import java.util.List;

public interface IScheduleService {
    List<Schedule> getWeekSchedule(Course course,Group group) throws ServiceException;
    /**
     * Weekday index. From 1 to 7. Start with monday (1 - monday, 2 - tuesday ...)
     */
    Schedule getDaySchedule(Course course,Group group, Long weekDay) throws ServiceException;
    void updateWeekSchedule(List<Schedule> scheduleList) throws ServiceException;
    void updateDaySchedule(Schedule schedule) throws ServiceException;
}