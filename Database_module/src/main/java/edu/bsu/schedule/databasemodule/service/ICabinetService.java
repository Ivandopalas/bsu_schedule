package edu.bsu.schedule.databasemodule.service;

import edu.bsu.schedule.databasemodule.entity.orm.Cabinet;

public interface ICabinetService {
    Long addCabinet(Cabinet cabinet) throws ServiceException;
    void deleteCabinet(Cabinet cabinet) throws ServiceException;
}
