package pack.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pack.entities.Candidate;
import pack.entities.Company;
import pack.entities.User;
import pack.entities.Vacancy;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class VacancyDAO {
    public Vacancy findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Vacancy.class, id);
    }

    public void save(Vacancy user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Vacancy user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(user);
        tx1.commit();
        session.close();
    }

    public void delete(Vacancy user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }



    public List<Vacancy> findAll() {
        List<Vacancy> contacts = (List<Vacancy>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Vacancy").list();
        return contacts;
    }

    public List<Vacancy> findByCompany(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Vacancy where company = :company");
        query.setParameter("company", company);
        List<Vacancy> res = query.list();
        return res;
    }

    public void deleteById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Vacancy todelete = (Vacancy) session.get(Vacancy.class, id);
        session.delete(todelete);
        tx1.commit();
    }
}
