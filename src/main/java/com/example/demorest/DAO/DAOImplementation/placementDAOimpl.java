package com.example.demorest.DAO.DAOImplementation;

import com.example.demorest.Bean.employee;
import com.example.demorest.Bean.placement;
import com.example.demorest.DAO.placementDAO;
import com.example.demorest.Util.HibernateSessionUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class placementDAOimpl implements placementDAO {

    @Override
    public void addPlacement(placement p) {

        //Session session = SessionUtils.getSession();

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(p);
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