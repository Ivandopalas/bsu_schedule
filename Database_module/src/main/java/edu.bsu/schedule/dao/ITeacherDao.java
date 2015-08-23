package edu.bsu.schedule.dao;

import edu.bsu.schedule.entity.Teacher;

import java.util.List;

public interface ITeacherDao {
    Long addTeacher(Teacher teacher) throws DaoException;
    void updateTeacher(Teacher teacherUpdated) throws DaoException;
    void deleteTeacher(Teacher teacher) throws DaoException;
    List<Teacher> getTeacherList() throws DaoException;
}
