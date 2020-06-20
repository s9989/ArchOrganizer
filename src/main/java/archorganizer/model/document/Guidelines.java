package archorganizer.model.document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Guidelines extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name="guidelines",
            joinColumns=@JoinColumn(name="document_id")
    )
    private List<String> guidelines = new ArrayList<>();;

    public Guidelines() {}

    public Guidelines(String documentName) {
        super(documentName);
    }

    public String getDocumentType() {
        return Document.DOCUMENT_TYPE_GUIDELINES;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addGuideline(String guideline) {
        this.guidelines.add(guideline);
    }

    public List<String> getGuidelines() {
        return guidelines;
    }
}
