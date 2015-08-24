package edu.bsu.schedule.databasemodule.dao.impl.hibernate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import edu.bsu.schedule.databasemodule.config.TestApplicationConfig;
import edu.bsu.schedule.databasemodule.dao.DaoException;
import edu.bsu.schedule.databasemodule.dao.ITeacherDao;
import edu.bsu.schedule.databasemodule.entity.Teacher;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@Transactional
public class TeacherDaoImplTest {
        @Autowired
        private ITeacherDao teacherDao;
        @Autowired
        private SessionFactory sessionFactory;

        @Test
        public void addTeacherTest() throws DaoException{
                Teacher teacher = new Teacher();
                teacher.setName("test");
                teacherDao.addTeacher(teacher);
                Session session = sessionFactory.getCurrentSession();
                Teacher teacherAdded = (Teacher)session.createQuery("FROM Teacher t where t.name = 'test'").uniqueResult();
                assertNotNull(teacherAdded);
        }
        @DatabaseSetup(value = "/testData/teacherData.xml", type= DatabaseOperation.REFRESH)
         @Test
         public void updateTeacherTest() throws DaoException{
                Session session = sessionFactory.getCurrentSession();
                Teacher actualTeacher = (Teacher)session.load(Teacher.class,1L);
                Teacher toUpdateTeacher = new Teacher();
                toUpdateTeacher.setTeacherId(actualTeacher.getTeacherId());
                toUpdateTeacher.setName("updated teacher");

                teacherDao.updateTeacher(toUpdateTeacher);

                Teacher updatedTeacher = (Teacher)session.load(Teacher.class,1L);
                assertEquals("updated teacher",updatedTeacher.getName());
        }

        @DatabaseSetup(value = "/testData/teacherData.xml", type= DatabaseOperation.REFRESH)
        @Test
        public void deleteTeacherTest() throws DaoException{
                Session session = sessionFactory.getCurrentSession();
                Teacher actualTeacher = (Teacher)session.load(Teacher.class,1L);

                teacherDao.deleteTeacher(actualTeacher);

                Teacher deletedTeacher = (Teacher)session.get(Teacher.class, 1L);
                assertNull(deletedTeacher);
        }

        @DatabaseSetup(value = "/testData/teacherData.xml", type= DatabaseOperation.REFRESH)
        @Test
        public void getTeacherListTest() throws DaoException{
                Session session = sessionFactory.getCurrentSession();
                List<Teacher> teacherList= teacherDao.getTeacherList();
                assertEquals(4,teacherList.size());
        }

}
