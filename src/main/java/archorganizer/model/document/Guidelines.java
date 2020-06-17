package archorganizer.model.document;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guidelines extends Document{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<String> guidelines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addGuideline(String guideline) {
        this.guidelines.add(guideline);
    }

    @ElementCollection
    @CollectionTable(
            name="guidelines",
            joinColumns=@JoinColumn(name="document_id")
    )
    public List<String> getGuidelines() {
        return guidelines;
    }

    @Override
    public String generate() {
        return ""; // @todo
    }
}
