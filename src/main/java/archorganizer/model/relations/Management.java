package archorganizer.model.relations;

import archorganizer.model.project.Project;
import archorganizer.model.user.Architect;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "architect_id", nullable = false)
    private Architect architect;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Management() {}

    public Management(Architect architect, Project project) {
        this.architect = architect;
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
}
