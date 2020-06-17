package archorganizer.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    public Investor() {}

    public Investor(@NotBlank String companyName, @NotBlank String contact) {
        setCompanyName(companyName);
        setContact(contact);
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
