package archorganizer.model.user;

import archorganizer.model.document.Invoice;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Accountant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String entitlementNumber;

    @OneToMany(mappedBy = "accountant", cascade = {CascadeType.ALL})
    private Set<Invoice> invoices = new HashSet<>();

    public Accountant() {}

    public Accountant(@NotBlank String entitlementNumber) {
        setEntitlementNumber(entitlementNumber);
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

    public String getEntitlementNumber() {
        return entitlementNumber;
    }

    public void setEntitlementNumber(String entitlementNumber) {
        this.entitlementNumber = entitlementNumber;
    }

    public String getFullName() {
        return this.user.getFullName();
    }
}
