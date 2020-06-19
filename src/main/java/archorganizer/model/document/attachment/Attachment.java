package archorganizer.model.document.attachment;

import archorganizer.model.complex.ColorSet;
import archorganizer.model.project.Project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Attachment {

    public static Attachment createOffice(String instituteName, String documentName, String referenceNumber) {
        Attachment attachment = new Attachment();
        attachment.office = new Office(attachment, instituteName, documentName, referenceNumber);
        return attachment;
    }

    public static Attachment createOffice(String instituteName, String documentName, String referenceNumber, LocalDate validationdDate) {
        Attachment attachment = new Attachment();
        attachment.office = new Office(attachment, instituteName, documentName, referenceNumber, validationdDate);
        return attachment;
    }

    public static Attachment createNetwork(String type) {
        Attachment attachment = new Attachment();
        attachment.network = new Network(attachment, type);
        return attachment;
    }

    public static Attachment createNetwork(String type, String status) {
        Attachment attachment = new Attachment();
        attachment.network = new Network(attachment, type, status);
        return attachment;
    }

    public static Attachment createStandard(String documentName, double budget) {
        Attachment attachment = new Attachment();
        attachment.standard = new Standard(attachment, documentName, budget);
        return attachment;
    }

    public static Attachment createStandard(String documentName, double budget, ColorSet colorSet) {
        Attachment attachment = new Attachment();
        attachment.standard = new Standard(attachment, documentName, budget, colorSet);
        return attachment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double cost;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "network_id", referencedColumnName = "id")
    private Network network;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "standard_id", referencedColumnName = "id")
    private Standard standard;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private Attachment() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
