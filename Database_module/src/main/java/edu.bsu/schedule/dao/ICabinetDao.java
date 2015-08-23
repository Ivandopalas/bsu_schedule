package edu.bsu.schedule.dao;

import edu.bsu.schedule.entity.Cabinet;

public interface ICabinetDao {
    Long addCabinet(Cabinet cabinet) throws DaoException;
    void deleteCabinet(Cabinet cabinet) throws DaoException;
}
