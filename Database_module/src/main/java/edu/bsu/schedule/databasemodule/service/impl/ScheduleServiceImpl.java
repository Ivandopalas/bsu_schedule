package edu.bsu.schedule.databasemodule.service.impl;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.IGroupDao;
import edu.bsu.schedule.databasemodule.dao.IScheduleDao;
import edu.bsu.schedule.databasemodule.entity.orm.Course;
import edu.bsu.schedule.databasemodule.entity.orm.Group;
import edu.bsu.schedule.databasemodule.entity.orm.Schedule;
import edu.bsu.schedule.databasemodule.entity.orm.Subject;
import edu.bsu.schedule.databasemodule.entity.vo.ScheduleVO;
import edu.bsu.schedule.databasemodule.entity.vo.SubjectVO;
import edu.bsu.schedule.databasemodule.service.IScheduleService;
import edu.bsu.schedule.databasemodule.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleDao scheduleDao;

    @Autowired
    private IGroupDao groupDao;

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

    public List<ScheduleVO> getWeekScheduleVO(Long course, String groupIndex) throws ServiceException {
        try{
            Course courseObj = new Course();
            courseObj.setCourseId(course);
            Group groupObj = groupDao.getGroupByIndex(groupIndex);
            List<Schedule> scheduleList = scheduleDao.getWeekSchedule(courseObj, groupObj);
            List<ScheduleVO> scheduleVOList = new ArrayList<ScheduleVO>();
            for (Schedule schedule : scheduleList) {
                List<SubjectVO> subjectVOList = new ArrayList<SubjectVO>();

                for (Subject subject : schedule.getSubjects()) {
                    SubjectVO subjectVO = new SubjectVO();
                    subjectVO.setSubjectName(subject.getSubjectName());
                    subjectVO.setCabinet(subject.getCabinet().getCabinetNumber());
                    subjectVO.setSubjectTime(subject.getSubjectTime());
                    subjectVO.setTeacherName(subject.getTeacher().getName());
                    subjectVOList.add(subjectVO);
                }
                ScheduleVO scheduleVO = new ScheduleVO();
                scheduleVO.setSubjectVO(subjectVOList);
                scheduleVO.setWeekday(schedule.getWeekday());
                scheduleVOList.add(scheduleVO);
            }
            return scheduleVOList;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
    public List<Schedule> getWeekSchedule(Long course, String groupIndex) throws ServiceException {
        try{
            Course courseObj = new Course();
            courseObj.setCourseId(course);
            Group groupObj = groupDao.getGroupByIndex(groupIndex);
            List<Schedule> scheduleList = scheduleDao.getWeekSchedule(courseObj, groupObj);
            return scheduleList;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public Schedule getDaySchedule(Long course, String groupIndex, Long weekDay) throws ServiceException {
        try{
            Course courseObj = new Course();
            courseObj.setCourseId(course);
            Group groupObj = groupDao.getGroupByIndex(groupIndex);
            Schedule schedule = scheduleDao.getDaySchedule(courseObj, groupObj,weekDay);
            return schedule;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
    public ScheduleVO getDayScheduleVO(Long course, String groupIndex, Long weekDay) throws ServiceException {
        try{
            Course courseObj = new Course();
            courseObj.setCourseId(course);
            Group groupObj = groupDao.getGroupByIndex(groupIndex);
            Schedule schedule = scheduleDao.getDaySchedule(courseObj, groupObj,weekDay);
            ScheduleVO scheduleVO = new ScheduleVO();
            if(schedule!=null) {
                List<SubjectVO> subjectVOList = new ArrayList<SubjectVO>();
                for (Subject subject : schedule.getSubjects()) {
                    SubjectVO subjectVO = new SubjectVO();
                    subjectVO.setSubjectName(subject.getSubjectName());
                    subjectVO.setCabinet(subject.getCabinet().getCabinetNumber());
                    subjectVO.setSubjectTime(subject.getSubjectTime());
                    subjectVO.setTeacherName(subject.getTeacher().getName());
                    subjectVOList.add(subjectVO);
                }
                scheduleVO.setSubjectVO(subjectVOList);
                scheduleVO.setWeekday(schedule.getWeekday());
            }
            return scheduleVO;
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
