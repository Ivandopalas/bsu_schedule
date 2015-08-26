package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.IGroupDao;
import edu.bsu.schedule.databasemodule.entity.orm.Group;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements IGroupDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Group getGroupByIndex(String groupIndex) throws DaoException {
        Session session = getSession();
        try{
            Group group = (Group)session.createCriteria(Group.class)
                    .add(Restrictions.eq("groupIndex", groupIndex))
                    .uniqueResult();
            return group;
        }catch(HibernateException ex){
            throw new DaoException(ex);
        }
    }
}
