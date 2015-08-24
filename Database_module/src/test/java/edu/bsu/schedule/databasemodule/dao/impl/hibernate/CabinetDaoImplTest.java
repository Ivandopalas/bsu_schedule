package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import edu.bsu.schedule.databasemodule.config.TestApplicationConfig;
import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.ICabinetDao;
import edu.bsu.schedule.databasemodule.entity.Cabinet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@Transactional
public class CabinetDaoImplTest {
    @Autowired
    private ICabinetDao cabinetDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void addCabinetTest() throws DaoException{
        Cabinet cabinet = new Cabinet();
        cabinet.setCabinetNumber("234b");
        cabinetDao.addCabinet(cabinet);

        Session session = sessionFactory.getCurrentSession();
        Cabinet cabinetAdded = (Cabinet)session.createQuery("FROM Cabinet c where c.cabinetNumber = '234b'").uniqueResult();
        assertNotNull(cabinetAdded);
    }

    @DatabaseSetup(value = "/testData/cabinetData.xml", type= DatabaseOperation.REFRESH)
    @Test
    public void deleteCabinetTest() throws DaoException{
        Session session = sessionFactory.getCurrentSession();
        Cabinet actualCabinet = (Cabinet)session.load(Cabinet.class,1L);

        cabinetDao.deleteCabinet(actualCabinet);

        Cabinet deletedCabinet = (Cabinet)session.get(Cabinet.class, 1L);
        assertNull(deletedCabinet);
    }
}
