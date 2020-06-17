package archorganizer.model.document.attachment;

import archorganizer.model.document.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Office extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String instituteName;

    private String referenceNumber;

    private Date validationDate;

    @Override
    public String generate() {
        return ""; // @todo
    }

}
