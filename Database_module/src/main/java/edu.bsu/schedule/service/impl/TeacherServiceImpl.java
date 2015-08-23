package edu.bsu.schedule.service.impl;

import edu.bsu.schedule.dao.DaoException;
import edu.bsu.schedule.dao.ITeacherDao;
import edu.bsu.schedule.entity.Teacher;
import edu.bsu.schedule.service.ITeacherService;
import edu.bsu.schedule.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService{
    @Autowired
    private ITeacherDao teacherDao;


    public Long addTeacher(Teacher teacher) throws ServiceException {
        try{
            Long teacherId = teacherDao.addTeacher(teacher);
            return teacherId;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public void updateTeacher(Teacher teacherUpdated) throws ServiceException {
        try{
            teacherDao.updateTeacher(teacherUpdated);
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public void deleteTeacher(Teacher teacher) throws ServiceException {
        try{
            teacherDao.deleteTeacher(teacher);
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public List<Teacher> getTeacherList() throws ServiceException {
        try{
            List<Teacher> teacherList = teacherDao.getTeacherList();
            return teacherList;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
}
