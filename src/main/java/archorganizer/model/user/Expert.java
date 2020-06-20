package archorganizer.model.user;

import archorganizer.model.project.Stage;
import archorganizer.model.relations.Implementation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Expert {

    final public static String SPECIALISATION_SANITATION   = "Instalacje sanitarne";
    final public static String SPECIALISATION_GREEN        = "Architektura krajobrazu";
    final public static String SPECIALISATION_FIRE         = "Systemy przeciwpożarowe";
    final public static String SPECIALISATION_CONSTRUCTION = "Konstrukcja";
    final public static String SPECIALISATION_ELECTRICITY  = "Instalacje elektryczne";
    final public static String SPECIALISATION_ROADS        = "Drogi";

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

    @OneToMany(mappedBy = "expert", cascade = {CascadeType.ALL})
    public Set<Implementation> implementations = new HashSet<>();

    public Expert() {
    }

    public Expert(@NotBlank String companyName, @NotBlank String specialisation) {
        setCompanyName(companyName);
        setSpecialisation(specialisation);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullName() {
        return this.user.getFullName();
    }
}