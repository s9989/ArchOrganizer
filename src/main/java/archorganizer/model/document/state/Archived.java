package archorganizer.model.document.state;

import archorganizer.model.document.Document;
import archorganizer.model.user.Architect;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Archived {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate archivedDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Document document;

    public Archived() {}

    public Archived(Document document) {
        this.document = document;
        this.archivedDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArchivedDate() {
        return archivedDate;
    }
}
