package archorganizer.model.document.attachment;

import archorganizer.model.document.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attachment extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double cost;

    @Override
    public String generate() {
        return ""; // @todo
    }

}
