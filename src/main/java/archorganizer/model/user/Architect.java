package archorganizer.model.user;

import archorganizer.model.project.Project;
import archorganizer.model.relations.Management;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Architect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String diploma;

    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Management> managements = new HashSet<>();

    public Architect() {}

    public Architect(@NotBlank String diploma) {
        setDiploma(diploma);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public void addProject(Project project)
    {
        Management management = new Management(this, project);
        this.managements.add(management);
        project.managements.add(management);
    }
}
