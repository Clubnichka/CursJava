package pack.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pack.entities.Candidate;
import pack.entities.Contact;
import pack.entities.User;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class contactDAO {
    public Contact findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contact.class, id);
    }

    public void save(Contact user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Contact user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Contact user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }



    public List<Contact> findAll() {
        List<Contact> contacts = (List<Contact>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Contact").list();
        return contacts;
    }

    public List<Contact> findByUserId(long userId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = (User) session.get(User.class, userId);
        Query query = session.createQuery("From Contact where user = :user");
        query.setParameter("user", user);
        List<Contact> contacts = query.list();
        return contacts;
    }

    public void deleteById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Contact todelete = (Contact) session.get(Contact.class, id);
        session.delete(todelete);
        tx1.commit();
    }
}
