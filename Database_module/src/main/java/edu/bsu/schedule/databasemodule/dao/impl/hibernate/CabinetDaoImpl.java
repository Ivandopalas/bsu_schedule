package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.ICabinetDao;
import edu.bsu.schedule.databasemodule.entity.Cabinet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CabinetDaoImpl implements ICabinetDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Long addCabinet(Cabinet cabinet) throws DaoException {
        Session session = getSession();
        try{
            Long cabinetId = (Long)session.save(cabinet);
            return cabinetId;
        }catch (HibernateException ex){
            throw new DaoException(ex);
        }
    }

    public void deleteCabinet(Cabinet cabinet) throws DaoException {
        Session session = getSession();
        try{
            session.delete(cabinet);
        }catch (HibernateException ex){
            throw new DaoException(ex);
        }
    }
}
