package com.example.demorest.DAO.DAOImplementation;

import com.example.demorest.Bean.alumni_organisation;
import com.example.demorest.Bean.organisations;
import com.example.demorest.DAO.orgDAO;
import com.example.demorest.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class orgDAOimpl implements orgDAO {

    @Override
    public void addOrg(organisations o) {

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(o);
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
