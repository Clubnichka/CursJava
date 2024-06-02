package pack.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import pack.beans.Vacancy;
import pack.beans.Candidate;

@Controller
public class appController {
    private static int Usertype;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/chooser")
    public String chooser(){
        return "chooser";
    }

    @RequestMapping("/autorization")
    public String autorization(){
        return "autorization";
    }

    @RequestMapping("/Enter")
    public String Enter(@RequestParam String user, Model model){
        switch(user){
            case("Employee"):
                Usertype=1;
                return "HomeEmployee";
            case("Employer"):
                Usertype=2;
                return "HomeEmployer";
            case("Manager"):
                Usertype=3;
                return "HomeManager";
            case("Admin"):
                Usertype=4;
                return "HomeAdmin";
            default:
                return "index";
        }
    }
    @RequestMapping("/registration1")
    public String registration1(){
        return "registration1";
    }

    @RequestMapping("/pay")
    public String pay(){
        return "pay";
    }
    @RequestMapping("/Home")
    public String Home(){
        switch(Usertype){
            case(1):
                return "HomeEmployee";
            case(2):
                return "HomeEmployer";
            case(3):
                return "HomeManager";
            case(4):
                return "HomeAdmin";
            default:
                return "index";
        }
    }
    @RequestMapping("/resume")
    public String resume(){
        return "resume";
    }

    @RequestMapping("/createVac")
    public String createVac(){
        return "createVac";
    }
    @RequestMapping("/viewvacancies")
    public String viewvacancies(Model model){
        List<Vacancy> VList= new ArrayList<Vacancy>();
        Vacancy vac1=new Vacancy();
        vac1.setName("Name1");
        vac1.setDiscription("Discription1");
        vac1.setRequiredAge(20);
        vac1.setRequiredExpirience(2);
        VList.add(vac1);
        Vacancy vac2=new Vacancy();
        vac2.setName("Name2");
        vac2.setDiscription("Discription2");
        vac2.setRequiredAge(40);
        vac2.setRequiredExpirience(4);
        VList.add(vac2);
        model.addAttribute("vacancy", VList);
        return "viewvacancies";
    }

    @RequestMapping("/myVacList")
    public String MyVacList(Model model){
        List<Vacancy> VList= new ArrayList<Vacancy>();
        Vacancy vac1=new Vacancy();
        vac1.setName("Name1");
        vac1.setDiscription("Discription1");
        vac1.setRequiredAge(20);
        vac1.setRequiredExpirience(2);
        VList.add(vac1);
        Vacancy vac2=new Vacancy();
        vac2.setName("Name2");
        vac2.setDiscription("Discription2");
        vac2.setRequiredAge(40);
        vac2.setRequiredExpirience(4);
        VList.add(vac2);
        model.addAttribute("vacancy", VList);
        return "myVacList";
    }
    @RequestMapping("/viewcand")
    public String viewcand(Model model) {
        List<Candidate> VList = new ArrayList<Candidate>();
        Candidate vac1 = new Candidate();
        vac1.setName("Name1");
        vac1.setAboutMe("Discription1");
        vac1.setAge(20);
        vac1.setExpirience(2);
        VList.add(vac1);
        Candidate vac2 = new Candidate();
        vac2.setName("Name2");
        vac2.setAboutMe("Discription2");
        vac2.setAge(40);
        vac2.setExpirience(4);
        VList.add(vac2);
        model.addAttribute("cand", VList);
        return "viewcand";
    }

    @RequestMapping("/MEmployer")
    public String MEmployer(Model model) {
        List<Employer> VList = new ArrayList<Employer>();
        Employer vac1 = new Employer();
        vac1.setName("Name1");
        vac1.setCompanyName("Comp1");
        VList.add(vac1);
        Employer vac2 = new Employer();
        vac2.setName("Name2");
        vac1.setCompanyName("Comp2");
        VList.add(vac2);
        model.addAttribute("vacancy", VList);
        return "MEmployer";
    }

    @RequestMapping("/MEmployee")
    public String MEmployee(Model model) {
        List<Candidate> VList = new ArrayList<Candidate>();
        Candidate vac1 = new Candidate();
        vac1.setName("Name1");
        vac1.setAboutMe("Discription1");
        vac1.setAge(20);
        vac1.setExpirience(2);
        VList.add(vac1);
        Candidate vac2 = new Candidate();
        vac2.setName("Name2");
        vac2.setAboutMe("Discription2");
        vac2.setAge(40);
        vac2.setExpirience(4);
        VList.add(vac2);
        model.addAttribute("cand", VList);
        return "MEmployee";
    }
}
