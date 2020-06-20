package archorganizer.model.document;

import archorganizer.model.complex.InvoicePosition;
import archorganizer.model.complex.Subject;
import archorganizer.model.user.Accountant;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Invoice extends Document {

    static final public double VAT_VALUE = 23.0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate issueDate;

    private LocalDate paymentDate;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "accountant_id")
    private Accountant accountant;

    public String getDocumentType() {
        return Document.DOCUMENT_TYPE_INVOICE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Subject getReceiver() {
        return receiver;
    }

    public void setReceiver(Subject receiver) {
        this.receiver = receiver;
    }

    public Subject getIssuer() {
        return issuer;
    }

    public void setIssuer(Subject issuer) {
        this.issuer = issuer;
    }

    public List<InvoicePosition> getPositions() {
        return positions;
    }

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
}
