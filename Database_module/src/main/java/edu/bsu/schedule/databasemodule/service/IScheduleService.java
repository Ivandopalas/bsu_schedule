package edu.bsu.schedule.databasemodule.service;

import edu.bsu.schedule.databasemodule.entity.orm.Course;
import edu.bsu.schedule.databasemodule.entity.orm.Group;
import edu.bsu.schedule.databasemodule.entity.orm.Schedule;
import edu.bsu.schedule.databasemodule.entity.vo.ScheduleVO;

import java.util.List;

public interface IScheduleService {
    List<Schedule> getWeekSchedule(Course course,Group group) throws ServiceException;
    /**
     * Weekday index. From 1 to 7. Start with monday (1 - monday, 2 - tuesday ...)
     */
    Schedule getDaySchedule(Course course,Group group, Long weekDay) throws ServiceException;
    List<ScheduleVO> getWeekScheduleVO(Long course,String groupIndex) throws ServiceException;
    ScheduleVO getDayScheduleVO(Long course,String groupIndex, Long weekDay) throws ServiceException;
    List<Schedule> getWeekSchedule(Long course,String groupIndex) throws ServiceException;
    Schedule getDaySchedule(Long course,String groupIndex, Long weekDay) throws ServiceException;
    void updateWeekSchedule(List<Schedule> scheduleList) throws ServiceException;
    void updateDaySchedule(Schedule schedule) throws ServiceException;
}
