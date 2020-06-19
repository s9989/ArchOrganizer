package archorganizer.model.project;

import archorganizer.model.user.Expert;
import org.hibernate.jdbc.Expectation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Execution extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String materialSpecification;

    @ElementCollection
    @CollectionTable(
            name="details",
            joinColumns=@JoinColumn(name="stage_id")
    )
    private List<String> details = new ArrayList<>();

    public Execution() {}

    public Execution(Project project) {
        super(project);
    }

    public Execution(Project project, String materialSpecification) {
        this(project);
        this.materialSpecification = materialSpecification;
    }

    public Execution(Project project, List<String> details) {
        this(project);
        this.details = details;
    }

    public Execution(Project project, String materialSpecification, List<String> details) {
        this(project, materialSpecification);
        this.details = details;
    }

    @Override
    public String getType() {
        return Stage.TYPE_EXECUTION;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialSpecification() {
        return materialSpecification;
    }

    public void setMaterialSpecification(String materialSpecification) {
        this.materialSpecification = materialSpecification;
    }

    public List<String> getDetails() {
        return details;
    }

    public void addDetail(String detail) {
        this.details.add(detail);
    }
}
