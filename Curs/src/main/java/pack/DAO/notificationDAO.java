package pack.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pack.entities.Contact;
import pack.entities.User;
import pack.entities.Notification;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class notificationDAO {
    public Notification findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Notification.class, id);
    }

    public void save(Notification notification) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(notification);
        tx1.commit();
        session.close();
    }



    public void delete(Notification notification) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(notification);
        tx1.commit();
        session.close();
    }



    public List<Notification> findAll() {
        List<Notification> notifications = (List<Notification>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Notification ").list();
        return notifications;
    }



    public void deleteById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Notification todelete = (Notification) session.get(Notification.class, id);
        session.delete(todelete);
        tx1.commit();
    }

    public void update(Notification notification) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(notification);
        tx1.commit();
        session.close();
    }
}
