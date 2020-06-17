package archorganizer.model.project;

import javax.persistence.*;
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
    private List<String> details;

}
