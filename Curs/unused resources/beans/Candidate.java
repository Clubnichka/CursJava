package pack.beans;

public class Candidate {
    private long id;
    private String Name;
    private int Expirience;
    private String AboutMe;
    private int Age;
    private int RequiredSalary;
    private long uID;
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

    public long getuID() {
        return uID;
    }

    public void setuID(long uID) {
        this.uID = uID;
    }
}
