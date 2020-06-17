package archorganizer.model.document;

import archorganizer.model.complex.InvoicePosition;
import archorganizer.model.complex.Subject;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date issueDate;

    private Date paymentDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name", column=@Column(name="receiver_name")),
            @AttributeOverride(name="firstName", column=@Column(name="receiver_firstName")),
            @AttributeOverride(name="lastName", column=@Column(name="receiver_lastName")),
            @AttributeOverride(name="NIP", column=@Column(name="receiver_NIP")),
            @AttributeOverride(name="address", column=@Column(name="receiver_address"))
    })
    private Subject receiver;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name", column=@Column(name="issuer_name")),
            @AttributeOverride(name="firstName", column=@Column(name="issuer_firstName")),
            @AttributeOverride(name="lastName", column=@Column(name="issuer_lastName")),
            @AttributeOverride(name="NIP", column=@Column(name="issuer_NIP")),
            @AttributeOverride(name="address", column=@Column(name="issuer_address"))
    })
    private Subject issuer;

    @ElementCollection
    @CollectionTable(
            name="invoice_positions",
            joinColumns=@JoinColumn(name="invoice_id")
    )
    private List<InvoicePosition> positions;

    public double getNetValue()
    {
        double netValue = 0.0;
        for (InvoicePosition position : positions) {
            netValue += position.getNetValue();
        }
        return netValue;
    }

    public double getTaxValue()
    {
        double taxValue = 0.0;
        for (InvoicePosition position : positions) {
            taxValue += position.getTaxValue();
        }
        return taxValue;
    }

    public double getGrossValue()
    {
        double grossValue = 0.0;
        for (InvoicePosition position : positions) {
            grossValue += position.getGrossValue();
        }
        return grossValue;
    }

    @Override
    public String generate() {
        return ""; // @todo
    }
}
