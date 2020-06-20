package archorganizer.model.document.attachment;

import archorganizer.model.document.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Network extends Document {

    static final String STATUS_NEW      = "new";
    static final String STATUS_REJECTED = "rejected";
    static final String STATUS_ON_HOLD  = "on_hold";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private String status;

    @OneToOne(mappedBy = "network", cascade = {CascadeType.ALL})
    private Attachment attachment;

    public Network() {}

    public Network(@NotBlank Attachment attachment, @NotBlank String documentName) {
        super(documentName);
        this.attachment = attachment;
    }

    public Network(@NotBlank Attachment attachment, @NotBlank String documentName, @NotBlank String type) {
        this(attachment, documentName, type, STATUS_NEW);
    }

    public Network(@NotBlank Attachment attachment, @NotBlank String documentName, @NotBlank String type, @NotBlank String status) {
        this(attachment, documentName);
        setType(type);
        setStatus(status);
    }

    public String getDocumentType() {
        return Document.DOCUMENT_TYPE_NETWORK;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
