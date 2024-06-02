package pack.DAO;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pack.entities.Candidate;
import pack.entities.Contact;
import pack.entities.User;
import pack.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CandidateDAO {


    public Candidate findById(long id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Candidate.class, id);
    }

    public boolean save(Candidate user) {
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            if (user.getName()==null || user.getName().isEmpty()) {
                user=null;
            }
            session.save(user);
            tx1.commit();
            session.close();
            return true;}
        catch(Exception e){
            return false;
        }
    }

    public void update(Candidate user) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Candidate user) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }



    public List<Candidate> findAll() {

        List<Candidate> contacts = (List<Candidate>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Candidate").list();
        return contacts;
    }

    public List<Candidate> findByUserId(long userId) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = (User) session.get(User.class, userId);
        Query query = session.createQuery("From Candidate where user = :user");
        query.setParameter("user", user);
        List<Candidate> resumes = query.list();
        return resumes;
    }

    public void deleteById(long id) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Candidate todelete = (Candidate) session.get(Candidate.class, id);
        session.delete(todelete);
        tx1.commit();
    }


}
