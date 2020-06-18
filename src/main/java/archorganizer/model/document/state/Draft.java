package archorganizer.model.document.state;

import archorganizer.model.document.Document;

import javax.persistence.*;

@Entity
public class Draft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Document document;

    public Draft(Document document) {
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void changeName(String newName)
    {
        this.document.setDocumentName(newName);
    }

}
