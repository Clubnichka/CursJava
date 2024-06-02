package pack.Services;

import org.springframework.stereotype.Service;
import pack.DAO.CandidateDAO;
import pack.entities.Candidate;
import pack.entities.Company;
import pack.entities.Contact;
import pack.entities.Vacancy;

import java.util.ArrayList;
import java.util.List;
@Service
public class CandidateService {
    private CandidateDAO candidateDAO=new CandidateDAO();

    public Candidate findCandidate(long id) {
        return candidateDAO.findById(id);
    }

    public List<Candidate> getCandidateList() {

        return candidateDAO.findAll();
    }

    /*public Candidate findByUserId(long userId) {
        List<Candidate> list=candidateDAO.findAll();
        for (Candidate candidate : list) {
            if (candidate.getUser().getId()==userId){
                return candidate;
            }
        }
        return null;
    }*/

    public List<Candidate> findByUserId(long userId) {
       return candidateDAO.findByUserId(userId);
    }

    public List<Candidate> getCandidatesesByName(String name){
        List<Candidate> candidates=new ArrayList<>();
        for(Candidate c:candidateDAO.findAll()){
            if(c.getName().equals(name)){
                candidates.add(c);
            }
        }
        return candidates;

    }

    public boolean addCandidate(Candidate candidate){

        return candidateDAO.save(candidate);
    }
    public void removeCandidate(Candidate candidate){

        candidateDAO.delete(candidate);
    }

    public void removeCandidate(Long id){

        candidateDAO.deleteById(id);
    }

    public void update(Candidate candidate){
        candidateDAO.update(candidate);
    }

}
