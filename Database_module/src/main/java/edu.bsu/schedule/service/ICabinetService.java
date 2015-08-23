package edu.bsu.schedule.service;

import edu.bsu.schedule.entity.Cabinet;

public interface ICabinetService {
    Long addCabinet(Cabinet cabinet) throws ServiceException;
    void deleteCabinet(Cabinet cabinet) throws ServiceException;
}
