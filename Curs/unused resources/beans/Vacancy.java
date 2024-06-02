package pack.beans;

public class Vacancy {
    private long id;
    private String Name;
    private int requiredExpirience;
    private String Description;
    private int requiredAge;
    private int salary;
    private Company company;
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

    public Company getCompany() {
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
}
