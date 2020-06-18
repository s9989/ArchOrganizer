package archorganizer.model.user;

import archorganizer.model.relations.Summary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String companyName;

    @NotBlank
    private String contact;

    @OneToMany(mappedBy = "investor", cascade = {CascadeType.ALL})
    private Set<Summary> summaries = new HashSet<>();

    public Investor() {}

    public Investor(@NotBlank String companyName, @NotBlank String contact) {
        setCompanyName(companyName);
        setContact(contact);
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
