package edu.bsu.schedule.service.impl;

import edu.bsu.schedule.dao.DaoException;
import edu.bsu.schedule.dao.ICabinetDao;
import edu.bsu.schedule.entity.Cabinet;
import edu.bsu.schedule.service.ICabinetService;
import edu.bsu.schedule.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CabinetServiceImpl implements ICabinetService{

    @Autowired
    private ICabinetDao cabinetDao;

    public Long addCabinet(Cabinet cabinet) throws ServiceException {
        try{
            Long cabinetId = cabinetDao.addCabinet(cabinet);
            return cabinetId;
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }

    public void deleteCabinet(Cabinet cabinet) throws ServiceException {
        try{
            cabinetDao.deleteCabinet(cabinet);
        }catch (DaoException ex){
            throw new ServiceException(ex);
        }
    }
}
