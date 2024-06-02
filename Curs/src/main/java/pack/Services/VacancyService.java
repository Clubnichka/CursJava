package pack.Services;

import org.springframework.stereotype.Service;
import pack.DAO.CandidateDAO;
import pack.DAO.VacancyDAO;
import pack.entities.Company;
import pack.entities.Vacancy;
import pack.entities.Candidate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
@Service
public class VacancyService {
    private VacancyDAO vacancyDAO=new VacancyDAO();
    public List<Vacancy> getVacancyList() {

        return vacancyDAO.findAll();
    }
    public List<Vacancy> getVacanciesByName(String name){
        List<Vacancy> vacancies=new ArrayList<>();
        for(Vacancy c:vacancyDAO.findAll()){
            if(c.getName().equals(name)){
                vacancies.add(c);
            }
        }
        return vacancies;

    }

    public void addVacancy(Vacancy vacancy){

        vacancyDAO.save(vacancy);
    }
    public void removeVacancy(Vacancy vacancy){

        vacancyDAO.delete(vacancy);
    }

    public void removeVacancy(long id){

        vacancyDAO.deleteById(id);
    }

    public void update (Vacancy vacancy){
        vacancyDAO.update(vacancy);
    }

    public List<Vacancy> getVacanciesByCompany(Company company) {
        return vacancyDAO.findByCompany(company);
    }

    public Vacancy getVacancieById(long id) {
        return vacancyDAO.findById(id);
    }
}
