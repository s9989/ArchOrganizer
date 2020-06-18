package archorganizer.model.project;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Building extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ElementCollection
    @CollectionTable(
            name="arrangements",
            joinColumns=@JoinColumn(name="stage_id")
    )
    private List<String> arrangements = new ArrayList<>();;

    public Building(Project project) {
        super(project);
    }

    public Building(Project project, @NotBlank List<String> arrangements) {
        this(project);
        this.arrangements = arrangements;
    }

    public List<String> getArrangements() {
        return arrangements;
    }

    public void addArrangement(String arrangement) {
        this.arrangements.add(arrangement);
    }
}
