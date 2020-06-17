package archorganizer.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Expert {

    final public static String SPECIALISATION_SANITATION   = "Sieci sanitarne";
    final public static String SPECIALISATION_GREEN        = "Tereny zielone";
    final public static String SPECIALISATION_FIRE         = "Systemy przeciwpożarowe";
    final public static String SPECIALISATION_CONSTRUCTION = "Konstruktor";
    final public static String SPECIALISATION_ELECTRICITY  = "Sieci elektryczne";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String companyName;

    @NotBlank
    private String specialisation;

    public Expert() {
    }

    public Expert(@NotBlank String companyName, @NotBlank String specialisation) {
        setCompanyName(companyName);
        setSpecialisation(specialisation);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
