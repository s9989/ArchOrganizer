package archorganizer.model.document.attachment;

import archorganizer.model.complex.ColorSet;
import archorganizer.model.document.Document;

import javax.persistence.*;
import java.util.List;

@Entity
public class Standard extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private ColorSet colorSet;

    private double budget;

    @ElementCollection
    @CollectionTable(
            name="materials_list",
            joinColumns=@JoinColumn(name="document_id")
    )
    private List<String> materialsList;

    @Override
    public String generate() {
        return ""; // @todo
    }

}
