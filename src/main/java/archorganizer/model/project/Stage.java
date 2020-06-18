package archorganizer.model.project;

import archorganizer.model.document.Document;
import archorganizer.model.relations.Implementation;
import archorganizer.model.relations.Summary;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected LocalDate startDate;

    protected LocalDate endDate;

    protected double budget;

    public Long getDuration()
    {
        if (endDate == null) {
            return startDate.until(LocalDate.now(), ChronoUnit.DAYS);
        }
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id", nullable = false)
    protected Project project;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    protected Set<Implementation> implementations = new HashSet<>();

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    protected Set<Material> materials = new HashSet<>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "summary_id")
    protected Summary summary;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    protected Set<Document> documents = new HashSet<>();

    public Stage(Project project) {
        this.project = project;
        this.startDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
