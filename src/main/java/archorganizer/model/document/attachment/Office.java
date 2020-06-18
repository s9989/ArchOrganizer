package archorganizer.model.document.attachment;

import archorganizer.model.document.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Office extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String instituteName;

    private String referenceNumber;

    private LocalDate validationDate;

    @OneToOne(mappedBy = "office", cascade = {CascadeType.ALL})
    private Attachment attachment;

    public Office(@NotBlank String instituteName, @NotBlank String referenceNumber) {
        setInstituteName(instituteName);
        setReferenceNumber(referenceNumber);
    }

    public Office(@NotBlank String instituteName, @NotBlank String referenceNumber, @NotBlank LocalDate validationDate) {
        this(instituteName, referenceNumber);
        setValidationDate(validationDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

}
