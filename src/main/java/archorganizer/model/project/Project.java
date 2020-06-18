package archorganizer.model.project;

import archorganizer.model.document.attachment.Attachment;
import archorganizer.model.relations.Management;
import archorganizer.model.user.Architect;
import archorganizer.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "architect", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Management> managements = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL})
    private Set<Attachment> attachments = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL})
    private Set<Stage> stages = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stage addConcept(String absorptivity) {
        Stage stage = absorptivity == null ? new Concept(this) : new Concept(this, absorptivity);
        this.stages.add(stage);
        return stage;
    }

    public Stage addBuilding(@NotBlank List<String> arrangements) {
        Stage stage = arrangements.isEmpty() ? new Building(this) : new Building(this, arrangements);
        this.stages.add(stage);
        return stage;
    }

    public Stage addExecution(@NotBlank List<String> details, String materialSpecification) {
        Stage stage;
        if (details.isEmpty()) {
            stage = materialSpecification == null ? new Execution(this) : new Execution(this, materialSpecification);
        } else {
            stage = materialSpecification == null ? new Execution(this, details) : new Execution(this, materialSpecification, details);
        }
        this.stages.add(stage);
        return stage;
    }

    public void setManager(Architect architect)
    {
        Management management = new Management(architect, this);
        this.managements.add(management);
        architect.managements.add(management);
    }
}
