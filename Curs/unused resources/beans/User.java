package pack.beans;

public class User {
    private long id;
    private String name;
    private int role;
    private int timer;
    private String password;
    private Contact associatedContact;
    private Company associatedCompany;

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

    public Contact getAssociatedContact() {
        return associatedContact;
    }

    public void setAssociatedContact(Contact associatedContact) {
        this.associatedContact = associatedContact;
    }

    public void addTime(int amount){
        this.timer+=amount;
    }

    public Company getAssociatedCompany() {
        return associatedCompany;
    }

    public void setAssociatedCompany(Company associatedCompany) {
        this.associatedCompany = associatedCompany;
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
}
