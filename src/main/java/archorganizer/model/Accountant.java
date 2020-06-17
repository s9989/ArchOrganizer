package archorganizer.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    public Accountant() {}

    public Accountant(@NotBlank String entitlementNumber) {
        setEntitlementNumber(entitlementNumber);
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
}
