package archorganizer.model.document.state;

import archorganizer.model.document.Document;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Processing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Document document;

    public Processing(Document document) {
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void archive() throws Exception
    {
        this.document.archive();
    }

}
