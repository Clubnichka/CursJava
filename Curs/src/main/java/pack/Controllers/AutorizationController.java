package pack.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pack.Services.NotificationService;
import pack.Services.UserService;
import pack.entities.User;

@Controller
public class AutorizationController {
    private int Usertype;
    public static long uID=0;
    UserService userService=new UserService();
    NotificationService notificationService=new NotificationService();
    @RequestMapping("/")
    public String index(){
        return "autorization/index";
    }


    @RequestMapping("/Create")
    public String addUser(@RequestParam String name, @RequestParam String password, @RequestParam Integer role, Model model){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        userService.saveUser(user);
        return "autorization/index";
    }
    @RequestMapping("/PLUG")
    public String plug(){
        return "Zaglushka";
    }

    @RequestMapping("/HA")
    public String HA(){
        return "admin/HomeAdmin";
    }

    @RequestMapping("/HC")
    public String HC(Model model){

        model.addAttribute("nots",notificationService.findMyNotifications(uID));
        return "employee/HomeEmployee";
    }

    @RequestMapping("/HC1")
    public String HC1(){
        return "employer/HomeEmployer";
    }

    @RequestMapping("/HM")
    public String HM(){
        return "manager/Home";
    }

    @RequestMapping("/autorization")
    public String autorization(Model model){
      return "autorization/autorization";
    }
    //@RequestMapping("/et")
    //  public String et(){
    //    return "entertest";
    //}


    @RequestMapping("/Enter")
    public String Enter(@RequestParam String name, @RequestParam String password, Model model){
        User u = new User();
        u.setRole(5);
        for (User user : userService.findAllUsers()) {
            if (user.getName().equals(name)&&user.getPassword().equals(password)) {
                u=user;
                uID=u.getId();
            }
        }
        switch (u.getRole()){
            case 0:
                return "admin/HomeAdmin";
            case 1:
                model.addAttribute("nots",notificationService.findMyNotifications(u.getId()));
                return "employee/HomeEmployee";
            case 2:
                return "employer/HomeEmployer";
            case 3:
                return "manager/Home";
            default:
                return "autorization/index";
        }
    }
    @RequestMapping("/registration")
    public String registration1(){
        return "autorization/registration";
    }
}
