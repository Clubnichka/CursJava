package pack.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pack.entities.Company;
import pack.entities.Contact;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CompanyDAO {
    public Company findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Company.class, id);
    }

    public void save(Company user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Company user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(user);
        tx1.commit();
        session.close();
    }

    public void delete(Company user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createNativeQuery("delete from users where Company_id = "+user.getId()).executeUpdate();
        tx1.commit();
        session.close();
        Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.delete(user);
        tx2.commit();
        session2.close();
    }

    public void delete(long id) {
        Session session3 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();
        session3.createNativeQuery("delete from contacts where company_id="+id).executeUpdate();

        tx3.commit();

        session3.close();
        Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.createNativeQuery("delete from users where Company_id="+id).executeUpdate();

        tx2.commit();

        session2.close();

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("delete from Company where id=:id").setParameter("id", id).executeUpdate();

        tx1.commit();

        session.close();
        /*Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx2 = session.beginTransaction();
        session.createNativeQuery("delete from contacts where Company_id = "+id).executeUpdate();
        tx2.commit();
        session2.close();
        Session session3= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx3 = session.beginTransaction();
        session.createNativeQuery("delete from Company where id = "+id).executeUpdate();
        tx3.commit();
        session3.close();*/
    }


    public List<Company> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Company> contacts = (List<Company>)  session.createQuery("From Company").list();
        session.close();
        return contacts;
    }
}
