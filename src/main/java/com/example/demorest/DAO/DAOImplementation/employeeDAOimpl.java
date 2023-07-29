package com.example.demorest.DAO.DAOImplementation;


import com.example.demorest.Bean.employee;
import com.example.demorest.DAO.employeeDAO;
import com.example.demorest.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class employeeDAOimpl implements employeeDAO {

    @Override
    @Deprecated
    public boolean emailVerify(employee emp) {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {
           // System.out.println(emp.getDepartment());
            if(emp.getDepartment().equals("outreach")) {
                Query query = session.createQuery("from employee where email=:email and first_name =: first_name and department=: dept ");
                query.setParameter("first_name", emp.getFirst_name());
                query.setParameter("email", emp.getEmail());
                query.setParameter("dept", emp.getDepartment());
                if (query.getResultList().size() == 1) {
                    return true;
                }
            }
            else
                return false;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }finally {
            session.close();
        }
         return false;
    }

    @Override
    @Deprecated
    public boolean addEmployee(employee emp) {

        //Session session = SessionUtils.getSession();

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(emp);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }finally {
            session.close();
        }
        return false;
    }
}