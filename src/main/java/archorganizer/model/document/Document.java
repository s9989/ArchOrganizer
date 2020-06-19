package archorganizer.model.document;

import archorganizer.model.document.state.Archived;
import archorganizer.model.document.state.Draft;
import archorganizer.model.document.state.Processing;
import archorganizer.model.project.Stage;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
abstract public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    private String number;

    private String documentName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "stage_id", nullable = true)
    private Stage stage;

    @OneToOne(cascade = {CascadeType.ALL})
    private Draft draft;

    @OneToOne(cascade = {CascadeType.ALL})
    private Processing processing;

    @OneToOne(cascade = {CascadeType.ALL})
    private Archived archived;

    public Document() {
        this.draft = new Draft(this);
    }

    public Document(String documentName) {
        this();
        this.documentName = documentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public void process() throws Exception {
        if (this.draft == null) {
            throw new Exception("Can't process not-draft document");
        }
        this.draft = null;
        this.processing = new Processing(this);
    }

    public void archive() throws Exception {
        if (this.processing == null) {
            throw new Exception("Can't archive not-processed document");
        }
        this.processing = null;
        this.archived = new Archived(this);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
