package archorganizer.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Architect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String diploma;

    public Architect() {}

    public Architect(@NotBlank String diploma) {
        setDiploma(diploma);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
}
