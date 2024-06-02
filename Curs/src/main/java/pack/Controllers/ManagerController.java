package pack.Controllers;

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
public class ManagerController {
    private CandidateService candidateService=new CandidateService();
    private VacancyService vacancyService=new VacancyService();
    private UserService userService=new UserService();
    private CompanyService companyService=new CompanyService();
    private ContactService contactService=new ContactService();
    private long id;

    @RequestMapping("/Mviewcandidates")
    public String viewCandidates(Model model){
        model.addAttribute("cands", candidateService.getCandidateList());
        return "manager/candidates";
    }

    @RequestMapping("/McandDetails")
    public String candDetails(@RequestParam Long id, Model model){
        model.addAttribute("cands",candidateService.findByUserId(id));
        model.addAttribute("conts", contactService.findByUserId(id));
        return "manager/candDetails";
    }

    @RequestMapping("/MselVac")
    public String selVac(Model model){
        List<Vacancy> vacancyList = vacancyService.getVacancyList();
        model.addAttribute("vacancy", vacancyList);
        return "manager/selVac";
    }

    @RequestMapping("/MfilterC")
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
        return "manager/candidates";
    }

    @RequestMapping("/Mviewvacancies")
    public String viewVacancies(Model model){
        model.addAttribute("vacancies", vacancyService.getVacancyList());
        return "manager/vacancies";
    }

    @RequestMapping("/MvacDetails")
    public String vacDetails(@RequestParam Long id,Model model){
        Vacancy vac=vacancyService.getVacancieById(id);
        model.addAttribute("vac",vac);
        return "manager/vacDetails";
    }

    @RequestMapping("/MselRes")
    public String selRes(Model model){
        model.addAttribute("cands",candidateService.getCandidateList());
        return "manager/selRes";
    }

    @RequestMapping("/Mfilter")
    public String filter(@RequestParam Long id,Model model){
        Candidate c=candidateService.findCandidate(id);
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
        return "manager/vacancies";
    }

    @RequestMapping("/Mviewcompanies")
    public String viewCompanies(Model model){
        this.id=0;
        model.addAttribute("comps", companyService.getCompaniesList());
        return "manager/companies";
    }

    @RequestMapping("/MaddComp")
    public String addComp(Model model){
        model.addAttribute("comp", new Company());
        return "manager/addComp";
    }

    @RequestMapping("/CreateComp")
    public String createComp(@ModelAttribute Company company, Model model){
        companyService.addCompany(company);
        model.addAttribute("comps", companyService.getCompaniesList());
        return "manager/companies";
    }

    @RequestMapping("/MaddCont")
    public String addCont(Model model){
        model.addAttribute("cont", new Contact());
        return "manager/addCont";
    }

    @RequestMapping("/McreateCont")
    public String McreateCont(@ModelAttribute Contact contact,Model model){
        Company company=companyService.getCompanyById(this.id);
        /*List<Contact> conts=company.getContacts();
        conts.add(contact);
        company.setContacts(conts);
        companyService.updateCompany(company);*/
        contact.setCompany(company);
        contactService.saveUser(contact);
        model.addAttribute("comps", companyService.getCompaniesList());
        this.id=0;
        return "manager/companies";
    }

    @RequestMapping("/McompCont")
    public String McompCont(@RequestParam Long id, Model model){
        model.addAttribute("conts", companyService.getCompanyById(id).getContacts());
        this.id=id;
        return "manager/contacts";
    }
}
