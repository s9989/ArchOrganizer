package archorganizer.model.project;

import archorganizer.model.document.Document;
import archorganizer.model.document.Elaboration;
import archorganizer.model.document.Guidelines;
import archorganizer.model.document.Invoice;
import archorganizer.model.relations.Implementation;
import archorganizer.model.relations.Summary;
import archorganizer.model.user.Expert;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@Entity
abstract public class Stage {

    static final public String TYPE_CONCEPT = "Koncepcja";
    static final public String TYPE_BUILDING = "Projekt budowlany";
    static final public String TYPE_EXECUTION = "Projekt wykonawczy";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected LocalDate startDate;

    protected LocalDate endDate;

    protected double budget;

    public Long getDuration()
    {
        if (endDate == null) {
            return startDate.until(LocalDate.now(), ChronoUnit.DAYS);
        }
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id", nullable = false)
    protected Project project;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    public Set<Implementation> implementations = new HashSet<>();

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    protected Set<Material> materials = new HashSet<>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "summary_id")
    protected Summary summary;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    protected Set<Document> documents = new HashSet<>();

    public Stage() {}

    public Stage(Project project) {
        this.project = project;
        this.startDate = LocalDate.now();
    }

    abstract public String getType();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public Set<Expert> getExperts()
    {
        Set<Expert> experts = new HashSet<>();
        for (Implementation implementation : implementations) {
            experts.add(implementation.getExpert());
        }
        return experts;
    }

    public void addExpert(Expert expert)
    {
        for (Implementation implementation : implementations) {
            if (implementation.getExpert().getId().equals(expert.getId())) {
                return;
            }
        }

        Implementation implementation = new Implementation(expert, this);
        this.implementations.add(implementation);
        expert.implementations.add(implementation);
    }

    public Implementation getImplementation(Expert expert)
    {
        for (Implementation implementation : implementations) {
            if (implementation.getExpert().getId() == expert.getId()) {
                return implementation;
            }
        }

        return null;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void addGuidelines(Guidelines guidelines) {
        guidelines.setStage(this);
        this.documents.add(guidelines);
    }

    public void addInvoice(Invoice invoice) {
        invoice.setStage(this);
        this.documents.add(invoice);
    }

    public Project getProject() {
        return this.project;
    }

    public Set<Document> getOtherDocuments() {
        Set<Document> results = new HashSet<Document>();
        for (Document document : documents) {
            if (!(document instanceof Invoice)) {
                results.add(document);
            }
        }
        return results;
    }

    public Set<Document> getInvoices() {
        Set<Document> results = new HashSet<Document>();
        for (Document document : documents) {
            if (document instanceof Invoice) {
                results.add(document);
            }
        }
        return results;
    }


}
