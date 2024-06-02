package pack.Services;

import pack.DAO.contactDAO;
import pack.entities.Candidate;
import pack.entities.Contact;

import java.util.List;

public class ContactService {
    private contactDAO usersDao = new contactDAO();

    public ContactService() {
    }

    public Contact findUser(long id) {
        return usersDao.findById(id);
    }

    public void saveUser(Contact user) {
        usersDao.save(user);
    }

    public void deleteUser(Contact user) {
        usersDao.delete(user);
    }

    public void updateUser(Contact user) {
        usersDao.update(user);
    }

    public List<Contact> findAllUsers() {
        return usersDao.findAll();
    }

    public List<Contact> findByUserId(long userId) {
        return usersDao.findByUserId(userId);
    }

    public void update(Contact contact){
        usersDao.update(contact);
    }

    public void deleteUser(long id) {

        usersDao.deleteById(id);
    }
}
