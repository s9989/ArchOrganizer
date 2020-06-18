package archorganizer.model.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Concept extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private String absorptivity;

    public Concept(@NotBlank Project project) {
        super(project);
    }

    public Concept(@NotBlank Project project, @NotBlank String absorptivity) {
        this(project);
        setAbsorptivity(absorptivity);
    }

    public String getAbsorptivity() {
        return absorptivity;
    }

    public void setAbsorptivity(String absorptivity) {
        this.absorptivity = absorptivity;
    }
}
