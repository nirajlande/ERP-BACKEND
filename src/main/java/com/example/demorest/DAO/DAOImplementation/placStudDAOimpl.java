package com.example.demorest.DAO.DAOImplementation;


import com.example.demorest.Bean.employee;
import com.example.demorest.Bean.placement_student;
import com.example.demorest.DAO.placStudDAO;
import com.example.demorest.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class placStudDAOimpl implements placStudDAO {

    @Override
    public void addPlacStud(placement_student ps) {

        //Session session = SessionUtils.getSession();

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(ps);
            transaction.commit();
            //return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            //return false;
        }finally {
            session.close();
        }
    }
}