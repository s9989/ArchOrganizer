package archorganizer.model.document.attachment;

import archorganizer.model.project.Project;

import javax.persistence.*;

@Entity
public class Attachment {

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

    Attachment(Office office) {
        this.office = office;
    }

    Attachment(Network network) {
        this.network = network;
    }

    Attachment(Standard standard) {
        this.standard = standard;
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
