package edu.bsu.schedule.dao;

import edu.bsu.schedule.entity.Course;
import edu.bsu.schedule.entity.Group;
import edu.bsu.schedule.entity.Schedule;

import java.util.List;

public interface IScheduleDao {
    List<Schedule> getWeekSchedule(Course course,Group group) throws DaoException;
    /**
     * Weekday index. From 1 to 7. Start with monday (1 - monday, 2 - tuesday ...)
     */
    Schedule getDaySchedule(Course course,Group group, Long weekDay) throws DaoException;
    void updateWeekSchedule(List<Schedule> scheduleList) throws DaoException;
    void updateDaySchedule(Schedule schedule) throws DaoException;
   // void editDaySchedule(Schedule schedule) throws DaoException;
}
