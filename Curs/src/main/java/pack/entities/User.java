package pack.entities;

import jakarta.persistence.*;
import pack.entities.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="role")
    private int role;
    //delete later
    @Column(name="timer")
    private int timer;
    //end
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Contact> Contacts;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Candidate> Candidates;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Company_id")
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Contact> getContacts() {
        return Contacts;
    }

    public void setContacts(List<Contact> contacts) {
        Contacts = contacts;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Candidate> getCandidates() {
        return Candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        Candidates = candidates;
    }
}
