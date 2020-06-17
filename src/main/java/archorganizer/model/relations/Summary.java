package archorganizer.model.relations;

import javax.persistence.*;
import java.util.List;

@Entity
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rate;

    @ElementCollection
    @CollectionTable(
            name="comments",
            joinColumns=@JoinColumn(name="summary_id")
    )
    private List<String> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }
}
