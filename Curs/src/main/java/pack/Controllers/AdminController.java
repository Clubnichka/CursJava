package pack.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.Services.*;
import pack.entities.Company;
import pack.entities.Contact;
import pack.entities.User;

import java.util.ArrayList;
import java.util.List;

import static pack.Controllers.AutorizationController.autorizer;

@Controller
public class AdminController {
    UserService userService=new UserService();
    CandidateService candidateService=new CandidateService();
    ContactService contactService=new ContactService();
    VacancyService vacancyService=new VacancyService();
    CompanyService companyService=new CompanyService();
    @RequestMapping("/Clients")
    public String Clients(Model model){
        List<User> res=new ArrayList();
        List<User> list = userService.findAllUsers();
        for (User i:list){
            if (i.getRole()==2||i.getRole()==1){
                res.add(i);
            }
        }
        model.addAttribute("List",res);


        return "admin/ClientList";
    }

    @RequestMapping("/Contacts")
    public String Contacts(@RequestParam Long userId, Model model){
        List<Contact> conts=contactService.findByUserId(userId);

        model.addAttribute("List",conts);


        return "admin/ContactList";
    }




    @RequestMapping("/Managers")
    public String Managers(Model model){
        List<User> res=new ArrayList();
        List<User> list = userService.findAllUsers();
        for (User i:list){
            if (i.getRole()==3){
                res.add(i);
            }
        }
        model.addAttribute("List",res);
        return "admin/ManagerList";
    }

    @RequestMapping("/DelManager")
    public String DM(@RequestParam Long ID, Model model){
        userService.deleteUserById(ID);
        List<User> res=new ArrayList();
        List<User> list = userService.findAllUsers();
        for (User i:list){
            if (i.getRole()==3){
                res.add(i);
            }
        }
        model.addAttribute("List",res);
        return "admin/ManagerList";
    }

    @RequestMapping("/AddManager")
    public String AM(Model model){

        return "admin/AddManager";
    }

    @RequestMapping("/CreateManager")
    public String addManager(@RequestParam String name, @RequestParam String password, @RequestParam Integer role, Model model){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        userService.saveUser(user);
        List<User> res=new ArrayList();
        List<User> list = userService.findAllUsers();
        for (User i:list){
            if (i.getRole()==3){
                res.add(i);
            }
        }
        model.addAttribute("List",res);
        return "admin/ManagerList";
    }

    @RequestMapping("/delClient")
    public String delClient(@RequestParam Long userId, Model model){
        userService.deleteUserById(userId);
        return "redirect:/Clients";
    }

    @RequestMapping("/Companies")
    public String Companies(Model model){
        model.addAttribute("comps", companyService.getCompaniesList());
        return "admin/companies";
    }

    @RequestMapping("/delComp")
    public String delComp(@RequestParam Long id, Model model){
        companyService.removeCompany(id);
        model.addAttribute("comps", companyService.getCompaniesList());
        return "admin/companies";
    }
}
