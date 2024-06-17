package exam2;

public class MailItem extends Package {
    private double weight;
    private String description;

    public MailItem(User sender, User recipient, double weight, String description) {
        super(sender, recipient);
        this.weight = weight;
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double estimatePrice(DistributionPoints destination, double weight) {
        return destination.getCostPerKg() * weight;
    }
}
