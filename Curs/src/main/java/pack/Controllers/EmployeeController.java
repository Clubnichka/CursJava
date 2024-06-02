package pack.Controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.Services.*;
import pack.entities.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private final Logger logger=Logger.getLogger(EmployeeController.class);
    private CandidateService CS=new CandidateService();
    private UserService us=new UserService();
    private ContactService contactService =new ContactService();
    private VacancyService vacancyService =new VacancyService();
    private CompanyService companyService =new CompanyService();
    private NotificationService notificationService =new NotificationService();
    private long delId;
    private boolean altering;
    private long altId;
    private long VacId;

    public EmployeeController() {
        altering=false;
    }

    @RequestMapping("/resume")
    public String resume(Model model){
        model.addAttribute("cand",new Candidate());

        return "employee/resume";
    }
    @RequestMapping("/viewRes")
    public String VR(Model model){
        model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
        return "employee/myRes";
    }
    @RequestMapping("/CreateResume")
    public String CR(@ModelAttribute Candidate cand, Model model){
        User user=new User();
        user=us.findUser(AutorizationController.uID);
        cand.setUser(user);
        if (altering){
            cand.setId(altId);
            CS.update(cand);
            altering=false;
            altId=0;
            model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
            return "employee/myRes";
        }
        else{
            boolean success=CS.addCandidate(cand);
            if (success){
                logger.info("Transaction successful");}
            else{
                logger.info("Transaction failed");
            }
        }
        return "employee/HomeEmployee";
    }

    @RequestMapping("/delRes")
    public String delRes(@RequestParam Long id, Model model){
        delId=id;
        return "employee/resDelConfirm";
    }

    @RequestMapping("/delConfirmed")
    public String delConfirmed(Model model){
        CS.removeCandidate(delId);
        model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
        return "employee/myRes";
    }

    @RequestMapping("/delCanceled")
    public String delCanceled(Model model){
        model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
        return "employee/myRes";
    }

    @RequestMapping("/alterRes")
    public String alterRes(@RequestParam Long id, Model model){
        altering=true;
        altId=id;
        model.addAttribute("cand",new Candidate());
        return "employee/resume";
    }

    @RequestMapping("/viewContact")
    public String viewCont(Model model){
        model.addAttribute("conts",contactService.findByUserId(AutorizationController.uID));
        return "employee/myCont";
    }

    @RequestMapping("/addCont")
    public String addCont(Model model){
        model.addAttribute("cont",new Contact());
        return "employee/contact";
    }

    @RequestMapping("/CreateCont")
    public String createCont(@ModelAttribute Contact cont, Model model){
        User user= us.findUser(AutorizationController.uID);
        cont.setUser(user);
        if (altering){
            cont.setId(altId);
            contactService.update(cont);
            altering=false;
            altId=0;
            model.addAttribute("conts",contactService.findByUserId(AutorizationController.uID));
            return "employee/myCont";
        }
        else{
            contactService.saveUser(cont);
        }
        model.addAttribute("conts",contactService.findByUserId(AutorizationController.uID));
        return "employee/myCont";
    }

    @RequestMapping("/delCont")
    public String delCont(@RequestParam Long id, Model model){
        delId=id;
        return "employee/contDelConfirm";
    }

    @RequestMapping("/delConfirmedC")
    public String delConfirmedC(Model model){
        contactService.deleteUser(delId);
        model.addAttribute("conts",contactService.findByUserId(AutorizationController.uID));
        return "employee/myCont";
    }

    @RequestMapping("/delCanceledC")
    public String delCanceledC(Model model){
        model.addAttribute("conts",contactService.findByUserId(AutorizationController.uID));
        return "employee/myCont";
    }

    @RequestMapping("/alterCont")
    public String alterCont(@RequestParam Long id, Model model){
        altering=true;
        altId=id;
        model.addAttribute("cont",new Contact());
        return "employee/contact";
    }

    @RequestMapping("/viewvacancies")
    public String viewVacancies(Model model){
        model.addAttribute("vacancies", vacancyService.getVacancyList());
        return "employee/vacancies";
    }

    @RequestMapping("/vacDetails")
    public String vacDetails(@RequestParam Long id,Model model){
        Vacancy vac=vacancyService.getVacancieById(id);
        if (vac!=null){
            logger.info("Transaction successful");
        }
        else{
            logger.info("Transaction not successful");
        }
        model.addAttribute("vac",vac);
        return "employee/vacDetails";
    }

    @RequestMapping("/selRes")
    public String selRes(Model model){
        model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
        return "employee/selRes";
    }

    @RequestMapping("/filter")
    public String filter(@RequestParam Long id,Model model){
        Candidate c=CS.findCandidate(id);
        List<Vacancy> res=new ArrayList<>();
        for (Vacancy vacancy: vacancyService.getVacancyList()){
            if(vacancy.getName().equals(c.getName())){
                if (vacancy.getRequiredAge()<=c.getAge()){
                    if (vacancy.getRequiredExpirience()<=c.getExpirience()){
                        if (vacancy.getSalary()>=c.getRequiredSalary()){
                            res.add(vacancy);
                        }
                        else {continue;}
                    }
                    else {continue;}
                }
                else {continue;}
            }
            else {continue;}
        }
        model.addAttribute("vacancies",res);
        return "employee/vacancies";
    }

    @RequestMapping("/selRes1")
    public String selRes1(@RequestParam Long id,Model model){
        model.addAttribute("cands",CS.findByUserId(AutorizationController.uID));
        this.VacId=id;
        return "employee/selRes1";
    }

    @RequestMapping("/notify")
    public String notify(@RequestParam Long id, Model model){
        Notification notification=new Notification();
        notification.setVacancy(vacancyService.getVacancieById(this.VacId));
        notification.setCandidate(CS.findCandidate(id));
        notification.setFeeadback(false);
        notificationService.saveUser(notification);
        this.VacId=0;
        return "redirect:/viewvacancies";
    }

    @RequestMapping("/EviewNots")
    public String viewNots(Model model){
        List<Notification> nots=notificationService.findMyNotifications(AutorizationController.uID);
        model.addAttribute("nots",nots);
        return "employee/nots";
    }
}
