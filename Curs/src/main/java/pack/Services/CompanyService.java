package pack.Services;

import pack.DAO.CandidateDAO;
import pack.DAO.CompanyDAO;
import pack.entities.Candidate;
import pack.entities.Company;
import pack.entities.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private CompanyDAO companyDAO=new CompanyDAO();
    public List<Company> getCompaniesList() {

        return companyDAO.findAll();
    }
    public List<Company> getCompaniesByName(String name){
        List<Company> companies=new ArrayList<>();
        for(Company c:companyDAO.findAll()){
            if(c.getName().equals(name)){
                companies.add(c);
            }
        }
        return companies;

    }

    public void addCompany(Company company){

        companyDAO.save(company);
    }
    public void removeCompany(Company company){

        companyDAO.delete(company);
    }

    public void removeCompany(long company){

        companyDAO.delete(company);
    }
    public Company getCompanyById(long id) {
        return companyDAO.findById(id);
    }

    public void updateCompany(Company company){
        companyDAO.update(company);
    }
}
