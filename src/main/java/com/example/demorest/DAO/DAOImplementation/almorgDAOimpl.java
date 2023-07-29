package com.example.demorest.DAO.DAOImplementation;

import com.example.demorest.Bean.alumni_organisation;
import com.example.demorest.Bean.employee;
import com.example.demorest.Bean.organisations;
import com.example.demorest.DAO.almorgDAO;
import com.example.demorest.DAO.employeeDAO;

import com.example.demorest.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class almorgDAOimpl implements almorgDAO {

    @Override
    public void addAlumni(alumni_organisation ao) {

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(ao);
            transaction.commit();
            //return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            //return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Object[]> getAlumni(organisations org) {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {

            System.out.println("Inside almorgDAlOimp.java");

            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);

            Date today = Calendar.getInstance().getTime();
            String todayAsString = df.format(today);

            System.out.println("------------Today is: ------- " + todayAsString);

            //String d="2018-12-08";
            Query query = session.createQuery("select distinct ao.alumni_name, ao.alumni_email, ao.joining_date, ao.leaving_date, organisations.name from alumni_organisation as ao inner join ao.org organisations" +
                    " where organisations.name =: name and (ao.leaving_date is null or ao.leaving_date >= :dat) order by ao.alumni_name");

            query.setParameter("name", org.getName());
            query.setParameter("dat", todayAsString);

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("1st elt of result: " + listResult.get(0)[0]);
            System.out.println("2nd elt of result: " + listResult.get(0)[1]);
            System.out.println("3rd elt of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }
}