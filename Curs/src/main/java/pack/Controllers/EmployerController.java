package pack.Controllers;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
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
public class EmployerController {
    private UserService userService = new UserService();
    private CandidateService candidateService = new CandidateService();
    private CompanyService companyService = new CompanyService();
    private ContactService contactService = new ContactService();
    private VacancyService vacancyService = new VacancyService();
    private NotificationService notificationService = new NotificationService();
    private long toDel;
    private long altId;
    private boolean altering;
    private long vacId;

    public EmployerController() {
        altering=false;
    }

    @RequestMapping("/company")
    public String company(Model model) {

        boolean exist = false;
        User u=userService.findUser(AutorizationController.uID);
        Company company=u.getCompany();
        if (company!=null) {
            exist=true;
        }
        if (exist){
            model.addAttribute("company", company);
            return "employer/myCompany";
        }
        else{
            return "employer/compAutorization";
        }
    }

    @RequestMapping("/EnterComp")
    public String EnterComp(@RequestParam String name, @RequestParam String password, Model model) {
        boolean exist = false;
        Company company = new Company();
        User u=userService.findUser(AutorizationController.uID);
        for (Company company1 : companyService.getCompaniesList()) {
            if (company1.getName().equals(name) && company1.getPassword().equals(password)) {
                company=company1;
                exist=true;
                break;
            }
        }
        if (exist){
            u.setCompany(company);
            userService.updateUser(u);
            model.addAttribute("company", company);
            return "employer/myCompany";
        }
        else {
            return "employer/compAutorization";
        }
    }

    @RequestMapping("/myVacList")
    public String myVacList(Model model) {
        User u=userService.findUser(AutorizationController.uID);
        List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
        model.addAttribute("vacancy", vacancyList);
        return "employer/myVacList";
    }

    @RequestMapping("/addVac")
    public String addVac(Model model) {
        model.addAttribute("vac", new Vacancy());
        return "employer/createVac";
    }

    /*@RequestMapping("/CreateVac")
    public String CreateVac(@ModelAttribute Vacancy vacancy, Model model) {
        User u=userService.findUser(AutorizationController.uID);
        vacancy.setCompany(u.getCompany());
        vacancyService.addVacancy(vacancy);
        List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
        model.addAttribute("vacancy", vacancyList);
        return "myVacList";



    }*/

    @RequestMapping("/CreateVac")
    public String CreateVac(@ModelAttribute Vacancy vacancy, Model model){
        User u=userService.findUser(AutorizationController.uID);
        vacancy.setCompany(u.getCompany());
        if (altering){
            vacancy.setId(altId);
            vacancyService.update(vacancy);
            altering=false;
            altId=0;
            List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
            model.addAttribute("vacancy", vacancyList);
            return "employer/myVacList";
        }
        else{
            vacancyService.addVacancy(vacancy);
            List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
            model.addAttribute("vacancy", vacancyList);
            return "employer/myVacList";
        }
    }

    @RequestMapping("/delVac")
    public String delVac(@RequestParam Long vacancyID, Model model) {
        toDel=vacancyID;
        return "employer/vacDelConfirm";
    }

    @RequestMapping("/delConfirmedV")
    public String delConfirmedV(Model model){
        vacancyService.removeVacancy(toDel);
        User u=userService.findUser(AutorizationController.uID);
        List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
        model.addAttribute("vacancy", vacancyList);
        return "employer/myVacList";

    }

    @RequestMapping("/delCanceledV")
    public String delCanceledV(Model model){
        User u=userService.findUser(AutorizationController.uID);
        List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
        model.addAttribute("vacancy", vacancyList);
        return "employer/myVacList";
    }

    @RequestMapping("/alterVac")
    public String alterCont(@RequestParam Long vacancyID, Model model){
        altering=true;
        altId=vacancyID;
        model.addAttribute("vac", new Vacancy());
        return "employer/createVac";
    }

    @RequestMapping("/viewcandidates")
    public String viewCandidates(Model model){
        model.addAttribute("cands", candidateService.getCandidateList());
        return "employer/candidates";
    }

    @RequestMapping("/candDetails")
    public String candDetails(@RequestParam Long id, Model model){
        model.addAttribute("cands",candidateService.findByUserId(id));
        model.addAttribute("conts", contactService.findByUserId(id));
        return "employer/candDetails";
    }

    @RequestMapping("/selVac")
    public String selVac(Model model){
        User u=userService.findUser(AutorizationController.uID);
        List<Vacancy> vacancyList = vacancyService.getVacanciesByCompany(u.getCompany());
        model.addAttribute("vacancy", vacancyList);
        return "employer/selVac";
    }

    @RequestMapping("/filterC")
    public String filterC(@RequestParam Long vacancyID,Model model){
        Vacancy v=vacancyService.getVacancieById(vacancyID);
        List<Candidate> res=new ArrayList<>();
        for (Candidate candidate: candidateService.getCandidateList()){
            if(v.getName().equals(candidate.getName())){
                if (v.getRequiredAge()<=candidate.getAge()){
                    if (v.getRequiredExpirience()<=candidate.getExpirience()){
                        if (v.getSalary()>=candidate.getRequiredSalary()){
                            res.add(candidate);
                        }
                        else {continue;}
                    }
                    else {continue;}
                }
                else {continue;}
            }
            else {continue;}
        }
        model.addAttribute("cands", res);
        return "employer/candidates";
    }

    @RequestMapping("/viewnots")
    public String viewNots(@RequestParam Long vacancyID, Model model){
        Vacancy v=vacancyService.getVacancieById(vacancyID);
        model.addAttribute("nots", v.getNotifications());
        return "employer/nots";
    }

    @RequestMapping("/conf")
    public String conf(@RequestParam Long notId, Model model){
        Notification notification=notificationService.findUser(notId);

        notification.setFeeadback(true);
        notificationService.updateNotification(notification);
        return "redirect:/myVacList";
    }

    @RequestMapping("/decl")
    public String decl(@RequestParam Long notId, Model model){
        notificationService.deleteUser(notId);
        return "redirect:/myVacList";
    }
}
