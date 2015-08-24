package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.IScheduleDao;
import edu.bsu.schedule.databasemodule.entity.Course;
import edu.bsu.schedule.databasemodule.entity.Group;
import edu.bsu.schedule.databasemodule.entity.Schedule;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDaoImpl implements IScheduleDao{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Schedule> getWeekSchedule(Course course, Group group) throws DaoException {
        Session session = getSession();
        try{
            List<Schedule> scheduleList = session.createCriteria(Schedule.class)
                    .add(Restrictions.eq("course", course))
                    .add(Restrictions.eq("group", group))
                    .addOrder(Order.asc("weekday"))
                    .list();
            return scheduleList;
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }

    public Schedule getDaySchedule(Course course, Group group, Long weekDay) throws DaoException {
        Session session = getSession();
        try{
            Schedule schedule = (Schedule)session.createCriteria(Schedule.class)
                    .add(Restrictions.eq("course", course))
                    .add(Restrictions.eq("group", group))
                    .add(Restrictions.eq("weekday",weekDay))
                    .addOrder(Order.asc("weekday"))
                    .uniqueResult();
            return schedule;
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }

    public void updateWeekSchedule(List<Schedule> scheduleList) throws DaoException {
        Session session = getSession();
        try{
            for(Schedule schedule : scheduleList){
                session.saveOrUpdate(schedule);
            }
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }


    public void updateDaySchedule(Schedule schedule) throws DaoException {
        Session session = getSession();
        try{
            session.saveOrUpdate(schedule);
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }
}
