package archorganizer.model.project;

import javax.persistence.*;
import java.util.List;

@Entity
public class Building extends Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name="arrangements",
            joinColumns=@JoinColumn(name="stage_id")
    )
    private List<String> arrangements;

}
