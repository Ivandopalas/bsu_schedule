package edu.bsu.schedule.service;

import edu.bsu.schedule.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    Long addTeacher(Teacher teacher) throws ServiceException;
    void updateTeacher(Teacher teacherUpdated) throws ServiceException;
    void deleteTeacher(Teacher teacher) throws ServiceException;
    List<Teacher> getTeacherList() throws ServiceException;
}
