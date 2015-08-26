package edu.bsu.schedule.databasemodule.dao;

import edu.bsu.schedule.databasemodule.entity.orm.Group;

public interface IGroupDao {
    Group getGroupByIndex(String groupIndex) throws DaoException;
}
