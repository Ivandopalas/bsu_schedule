package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.ITeacherDao;
import edu.bsu.schedule.databasemodule.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements ITeacherDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
   // @Transactional
    public Long addTeacher(Teacher teacher) throws DaoException {
        Session session = getSession();
        Long teacherId = null;
        try{
            teacherId = (Long) session.save(teacher);
            // still dont know. check later on service layer
            session.flush();
        }catch(HibernateException ex) {
            throw new DaoException(ex);
        }
        return teacherId;
    }
    public void updateTeacher(Teacher teacherUpdated) throws DaoException{
        Session session = getSession();
        try{
            Teacher actualTeacher = (Teacher)session.load(Teacher.class,teacherUpdated.getTeacherId());
            actualTeacher.setName(teacherUpdated.getName());
        }catch (HibernateException ex){
            throw new DaoException(ex);
        }
    }
    public void deleteTeacher(Teacher teacher) throws DaoException{
        Session session = getSession();
        try{
            session.delete(teacher);
        }catch (HibernateException ex){
            throw new DaoException(ex);
        }
    }
    public List<Teacher> getTeacherList() throws DaoException{
        Session session = sessionFactory.openSession();
        try{
            List<Teacher> teacherList = session.createCriteria(Teacher.class).list();
            return teacherList;
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }
}
