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

    public Building() {}

    public Building(Project project) {
        super(project);
    }

    public Building(Project project, @NotBlank List<String> arrangements) {
        this(project);
        this.arrangements = arrangements;
    }

    @Override
    public String getType() {
        return Stage.TYPE_BUILDING;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getArrangements() {
        return arrangements;
    }

    public void addArrangement(String arrangement) {
        this.arrangements.add(arrangement);
    }
}
