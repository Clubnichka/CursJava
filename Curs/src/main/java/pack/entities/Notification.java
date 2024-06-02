package pack.entities;

import jakarta.persistence.*;

@Entity
@Table(name="notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="feedback")
    private boolean feeadback;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Vacancy_id")
    private Vacancy vacancy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Resume_id")
    private Candidate candidate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public boolean isFeeadback() {
        return feeadback;
    }

    public void setFeeadback(boolean feeadback) {
        this.feeadback = feeadback;
    }
}
