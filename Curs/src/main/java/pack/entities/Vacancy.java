package pack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String Name;
    @Column(name="requiredExpirience")
    private int requiredExpirience;
    @Column(name= "description")
    private String Description;
    @Column(name="requiredAge")
    private int requiredAge;
    @Column(name="salary")
    private int salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Notification> Notifications;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setRequiredExpirience(int requiredExpirience) {
        this.requiredExpirience = requiredExpirience;
    }

    public int getRequiredExpirience() {
        return requiredExpirience;
    }
    public void setDiscription(String disc){
        Description=disc;
    }

    public String getDescription() {
        return Description;
    }

    public void setRequiredAge(int requiredAge) {
        this.requiredAge = requiredAge;
    }

    public int getRequiredAge() {
        return requiredAge;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public pack.entities.Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Notification> getNotifications() {
        return Notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        Notifications = notifications;
    }
}
