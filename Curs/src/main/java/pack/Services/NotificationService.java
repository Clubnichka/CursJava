package pack.Services;

import pack.DAO.notificationDAO;
import pack.entities.Contact;
import pack.entities.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private notificationDAO notificationDAO = new notificationDAO();

    public NotificationService() {
    }

    public Notification findUser(long id) {
        return notificationDAO.findById(id);
    }

    public void saveUser(Notification user) {
        notificationDAO.save(user);
    }

    public void deleteUser(Notification user) {
        notificationDAO.delete(user);
    }


    public List<Notification> findAllUsers() {
        return notificationDAO.findAll();
    }



    public void deleteUser(long id) {

        notificationDAO.deleteById(id);
    }

    public void updateNotification(Notification notification) {
        notificationDAO.update(notification);
    }

    public List<Notification> findMyNotifications(Long userId) {
        List<Notification> res=new ArrayList<Notification>();
        for (Notification notification:notificationDAO.findAll()) {
            if (notification.isFeeadback()){
                if(notification.getCandidate().getUser().getId()==userId){
                    res.add(notification);
                }
            }
        }
        return res;
    }
}
