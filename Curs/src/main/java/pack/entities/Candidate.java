package pack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String Name;
    @Column(name="expirience")
    private int Expirience;
    @Column(name="about_me")
    private String AboutMe;
    @Column(name="age")
    private int Age;
    @Column(name="requiredSalary")
    private int RequiredSalary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Notification> Notifications;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setExpirience(int requiredExpirience) {
        this.Expirience = requiredExpirience;
    }

    public int getExpirience() {
        return Expirience;
    }
    public void setAboutMe(String disc){
        AboutMe=disc;
    }

    public String getAboutMe() {
        return AboutMe;
    }

    public void setAge(int requiredAge) {
        this.Age = requiredAge;
    }

    public int getAge() {
        return Age;
    }

    public void setRequiredSalary(int salary) {
        this.RequiredSalary = salary;
    }

    public int getRequiredSalary() {
        return RequiredSalary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
