package edu.bsu.schedule.databasemodule.service;

import edu.bsu.schedule.databasemodule.entity.orm.Teacher;

import java.util.List;

public interface ITeacherService {
    Long addTeacher(Teacher teacher) throws ServiceException;
    void updateTeacher(Teacher teacherUpdated) throws ServiceException;
    void deleteTeacher(Teacher teacher) throws ServiceException;
    List<Teacher> getTeacherList() throws ServiceException;
}
