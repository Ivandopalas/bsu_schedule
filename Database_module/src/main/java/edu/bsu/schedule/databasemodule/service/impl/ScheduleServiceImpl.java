package edu.bsu.schedule.databasemodule.service.impl;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.IScheduleDao;
import edu.bsu.schedule.databasemodule.service.IScheduleService;
import edu.bsu.schedule.databasemodule.service.ServiceException;
import edu.bsu.schedule.databasemodule.entity.Course;
import edu.bsu.schedule.databasemodule.entity.Group;
import edu.bsu.schedule.databasemodule.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleDao scheduleDao;

    public List<Schedule> getWeekSchedule(Course course, Group group) throws ServiceException {
        try{
            List<Schedule> scheduleList = scheduleDao.getWeekSchedule(course, group);
            return scheduleList;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public Schedule getDaySchedule(Course course, Group group, Long weekDay) throws ServiceException {
        try{
            Schedule schedule = scheduleDao.getDaySchedule(course, group, weekDay);
            return schedule;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public void updateWeekSchedule(List<Schedule> scheduleList) throws ServiceException {
        try{
            scheduleDao.updateWeekSchedule(scheduleList);
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public void updateDaySchedule(Schedule schedule) throws ServiceException {
        try{
            scheduleDao.updateDaySchedule(schedule);
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
}
