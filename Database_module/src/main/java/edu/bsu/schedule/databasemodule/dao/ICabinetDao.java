package edu.bsu.schedule.databasemodule.dao;

import edu.bsu.schedule.databasemodule.entity.orm.Cabinet;

public interface ICabinetDao {
    Long addCabinet(Cabinet cabinet) throws DaoException;
    void deleteCabinet(Cabinet cabinet) throws DaoException;
}
