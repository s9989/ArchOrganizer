package archorganizer.model.complex;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {

    private String name;

    private String firstName;

    private String lastName;

    private String NIP;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "NIP: " +NIP + "\n" +
                name + "\n" +
                firstName + " " + lastName + "\n" +
                address;
    }
}
