package archorganizer.model.complex;

public class InvoicePosition {

    private Long number;

    private String description;

    private String pkwiu;

    private String type;

    private Long amount;

    private double itemNetValue;

    private double taxPercent;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPkwiu() {
        return pkwiu;
    }

    public void setPkwiu(String pkwiu) {
        this.pkwiu = pkwiu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public double getItemNetValue() {
        return itemNetValue;
    }

    public void setItemNetValue(double itemNetValue) {
        this.itemNetValue = itemNetValue;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getNetValue()
    {
        return amount * itemNetValue;
    }

    public double getTaxValue()
    {
        return getNetValue() * taxPercent;
    }

    public double getGrossValue()
    {
        return getNetValue() + getTaxValue();
    }
}
