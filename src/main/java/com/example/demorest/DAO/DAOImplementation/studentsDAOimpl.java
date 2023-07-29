package com.example.demorest.DAO.DAOImplementation;
import com.example.demorest.Bean.organisations;
import com.example.demorest.Bean.students;
import com.example.demorest.DAO.studentsDAO;
import com.example.demorest.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class studentsDAOimpl implements studentsDAO {

    @Override
    public boolean addStudents(students s) {

        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(s);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Object[]> getAll() {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");

            Query query = session.createQuery("select roll_number, first_name, last_name, email, specialisation, placement_id from students");

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

    @Override
    public List<Object[]> getPlaced_Students() {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {
            System.out.println("Inside studentsDAOimpl.java");

            Query query = session.createQuery("select distinct students.first_name, students.roll_number, students.email, organisations.name from placement_student as ps inner join ps.stds students, placement_student as ps1 inner join ps1.plcmnt placement inner join placement.org organisations" +
                    " where students.placement_id = ps.id and ps.id = ps1.id and ps.acceptance = 'ACCEPT' and students.placement_id is not null order by students.roll_number");

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

    @Override
    public List<Object[]> getNotPlaced_Students() {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");

            // select concat(students.first_name, ' ', students.last_name), s.roll_number, s.email from students s where s.placement_id is null order by s.roll_number;
            Query query = session.createQuery("select distinct s.first_name, s.roll_number, s.email from students s where s.placement_id is null order by s.roll_number");

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }
    @Override
    public List<Object[]> getSpecialisation(students st) {
        Session session = HibernateSessionUtil.getSession();

        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");

            System.out.println("\n choosen spl is " + st.getSpecialisation());

            Query query = session.createQuery("select distinct students.first_name, students.roll_number, students.email, organisations.name from placement_student as ps inner join ps.stds students, placement_student as ps1 inner join ps1.plcmnt placement inner join placement.org organisations" +
                   " where students.placement_id = ps.id and ps.id = ps1.id and ps.acceptance = 'ACCEPT' and students.placement_id is not null and students.specialisation =: spl order by students.roll_number");

            query.setParameter("spl", st.getSpecialisation());

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);


            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

    @Override
    public List<Object[]> getStudentsByOrg(organisations org) {
        Session session = HibernateSessionUtil.getSession();
        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");
            System.out.println("\n choosen spl is " + org.getName());

            Query query = session.createQuery("select distinct students.first_name, students.roll_number, students.email, organisations.name from placement_student as ps inner join ps.stds students, placement_student as ps1 inner join ps1.plcmnt placement inner join placement.org organisations" +
                    " where students.placement_id = ps.id and ps.id = ps1.id and ps.acceptance = 'ACCEPT' and students.placement_id is not null and organisations.name =: nam order by students.roll_number");

            query.setParameter("nam", org.getName());

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

    @Override
    @Deprecated
    public List<Object[]> getStudentsByYear(String yr) {
        Session session = HibernateSessionUtil.getSession();
        //List<students> stds = new ArrayList<>();
        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");

            System.out.println("\n choosen year is " + yr);

            String s = (new StringBuilder()).append("%").append(yr).append("%").toString();
            System.out.println("\n this goes into query: " + s);

            Query query = session.createQuery("select distinct students.first_name, students.roll_number, students.email, organisations.name from placement_student as ps inner join ps.stds students, placement_student as ps1 inner join ps1.plcmnt placement inner join placement.org organisations" +
                    " where students.placement_id = ps.id and ps.id = ps1.id and ps.acceptance = 'ACCEPT' and students.placement_id is not null and students.roll_number like :year order by students.roll_number");

            yr="%"+yr+"%";
            query.setParameter("year", yr);

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

    @Override
    @Deprecated
    public List<Object[]> getStudentsByDomain(String dmn) {
        Session session = HibernateSessionUtil.getSession();

        List<Object[]> listResult = null;
        try {

            System.out.println("Inside studentsDAOimpl.java");

            System.out.println("\n choosen year is " + dmn);

            String s = (new StringBuilder()).append("%").append(dmn).append("%").toString();
            System.out.println("\n this goes into query: " + s);

            Query query = session.createQuery("select distinct students.first_name, students.roll_number, students.email, organisations.name from placement_student as ps inner join ps.stds students, placement_student as ps1 inner join ps1.plcmnt placement inner join placement.org organisations" +
                    " where students.placement_id = ps.id and ps.id = ps1.id and ps.acceptance = 'ACCEPT' and students.placement_id is not null and students.roll_number like :year order by students.roll_number");

            dmn="%"+dmn+"%";
            query.setParameter("year", dmn );

            listResult = query.list();

            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }

}