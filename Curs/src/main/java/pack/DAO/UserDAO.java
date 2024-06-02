package pack.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pack.entities.Contact;
import pack.entities.User;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAO {
    public User findById(long id) {
        User user = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        user = (User) session.get(User.class, id);
        session.close();
    return user;
}

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(user);
        tx1.commit();
        session.close();
    }



    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }



    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> contacts = (List<User>)  session.createQuery("From User").list();
        session.close();
        return contacts;
    }

    public void deleteById(long id){
        Session session3 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();
        session3.createNativeQuery("delete from candidates where user_id="+id).executeUpdate();

        tx3.commit();

        session3.close();
        Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.createNativeQuery("delete from contacts where user_id="+id).executeUpdate();

        tx2.commit();

        session2.close();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("delete from User where id = :id")
                .setParameter("id", id).executeUpdate();
        tx1.commit();
        session.close();
    }
}
