package archorganizer.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    private Architect architect;

    @OneToOne(cascade = {CascadeType.ALL})
    private Expert expert;

    @OneToOne(cascade = {CascadeType.ALL})
    private Investor investor;

    @OneToOne(cascade = {CascadeType.ALL})
    private Accountant accountant;

    public User() {}

    public User(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String username, @NotBlank String password)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
    }

    public void addArchitect(@NotBlank String diploma) {
        this.architect = new Architect(diploma);
        this.architect.setUser(this);
    }

    public void addExpert(@NotBlank String companyName, @NotBlank String specialisation) {
        this.expert = new Expert(companyName, specialisation);
        this.expert.setUser(this);
    }

    public void addInvestor(@NotBlank String companyName, @NotBlank String contact) {
        this.investor = new Investor(companyName, contact);
        this.investor.setUser(this);
    }

    public void addAccountant(@NotBlank String entitlementNumber) {
        this.accountant = new Accountant(entitlementNumber);
        this.accountant.setUser(this);
    }

    public Architect getArchitect() {
        return this.architect;
    }

    public Expert getExpert() {
        return this.expert;
    }

    public Investor getInvestor() {
        return this.investor;
    }

    public Accountant getAccountant() {
        return this.accountant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
