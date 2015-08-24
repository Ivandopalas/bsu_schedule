package edu.bsu.schedule.databasemodule.dao.impl.hibernate;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import edu.bsu.schedule.databasemodule.config.TestApplicationConfig;
import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.IScheduleDao;
import edu.bsu.schedule.databasemodule.entity.Schedule;
import edu.bsu.schedule.databasemodule.entity.Course;
import edu.bsu.schedule.databasemodule.entity.Group;
import edu.bsu.schedule.databasemodule.entity.Subject;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@Transactional
public class ScheduleDaoImplTest {

    @Autowired
    private IScheduleDao scheduleDao;
    @Autowired
    private SessionFactory sessionFactory;

    @DatabaseSetup(value = "/testData/scheduleData.xml", type= DatabaseOperation.REFRESH)
    @Test
    public void updateDayScheduleTest() throws DaoException{
        Course course = new Course();
        course.setCourseId(1L);
        Group group = new Group();
        group.setGroupId(1L);
        group.setGroupIndex("9");
        group.setGroupName("Computer security");
        Schedule schedule = scheduleDao.getDaySchedule(course,group,1L);
        List<Subject> subjects = schedule.getSubjects();
        Subject subject = subjects.get(0);
        subject.setSubjectName("updated subject 1");
        scheduleDao.updateDaySchedule(schedule);

        Schedule updatedSchedule = scheduleDao.getDaySchedule(course,group,1L);

        assertEquals("updated subject 1",updatedSchedule.getSubjects().get(0).getSubjectName());
    }

    @DatabaseSetup(value = "/testData/scheduleData.xml", type= DatabaseOperation.REFRESH)
    @Test
    public void getWeekSchedule() throws DaoException{
        Course course = new Course();
        course.setCourseId(1L);
        Group group = new Group();
        group.setGroupId(1L);
        List<Schedule> schedules = scheduleDao.getWeekSchedule(course,group);

        assertEquals(7L,schedules.size());
        assertEquals(2L,schedules.get(0).getSubjects().size());
    }
}
