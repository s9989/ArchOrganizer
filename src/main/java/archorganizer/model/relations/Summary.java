package archorganizer.model.relations;

import archorganizer.model.project.Stage;
import archorganizer.model.user.Investor;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<String> comments = new ArrayList<>();;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    public void addComment(String comment) {
        this.comments.add(comment);
    }
}
