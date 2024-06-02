package pack.Services;

import pack.DAO.CandidateDAO;
import pack.DAO.UserDAO;
import pack.DAO.contactDAO;
import pack.entities.Candidate;
import pack.entities.Contact;
import pack.entities.User;

import java.util.List;

public class UserService {
    private UserDAO usersDao = new UserDAO();
    private contactDAO contactsDao = new contactDAO();
    private ContactService contactService = new ContactService();
    private CandidateService candidateService = new CandidateService();
    private CandidateDAO candidateDao = new CandidateDAO();

    public User findUser(long id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }
    public void deleteUserById(Long id) {
        usersDao.deleteById(id);
    }
}
