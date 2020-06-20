package archorganizer.model.document.attachment;

import archorganizer.model.complex.ColorSet;
import archorganizer.model.document.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Standard extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded()
    private ColorSet colorSet;

    private double budget;

    @ElementCollection
    @CollectionTable(
            name="materials_list",
            joinColumns=@JoinColumn(name="document_id")
    )
    private List<String> materialsList = new ArrayList<>();;

    @OneToOne(cascade = {CascadeType.ALL})
    private Attachment attachment;

    public Standard() {}

    public Standard(@NotBlank Attachment attachment, @NotBlank String documentName) {
        super(documentName);
        this.attachment = attachment;
    }

    public Standard(@NotBlank Attachment attachment, @NotBlank String documentName, @NotBlank double budget) {
        this(attachment, documentName, budget, new ColorSet());
    }

    public Standard(@NotBlank Attachment attachment, @NotBlank String documentName, @NotBlank double budget, @NotBlank ColorSet colorSet) {
        this(attachment, documentName);
        setBudget(budget);
        setColorSet(colorSet);
    }

    public String getDocumentType() {
        return Document.DOCUMENT_TYPE_STANDARD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ColorSet getColorSet() {
        return colorSet;
    }

    public void setColorSet(ColorSet colorSet) {
        this.colorSet = colorSet;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
