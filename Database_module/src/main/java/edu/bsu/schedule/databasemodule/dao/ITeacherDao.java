package edu.bsu.schedule.databasemodule.dao;

import edu.bsu.schedule.databasemodule.entity.orm.Teacher;

import java.util.List;

public interface ITeacherDao {
    Long addTeacher(Teacher teacher) throws DaoException;
    void updateTeacher(Teacher teacherUpdated) throws DaoException;
    void deleteTeacher(Teacher teacher) throws DaoException;
    List<Teacher> getTeacherList() throws DaoException;
}
