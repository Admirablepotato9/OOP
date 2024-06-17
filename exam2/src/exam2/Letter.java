package exam2;

public class Letter extends Package {

    public Letter(User sender, User recipient) {
        super(sender, recipient);
    }

    @Override
    public double estimatePrice(DistributionPoints destination, double weight) {
        // For a letter, the cost is the same as sending a 1kg package
        return destination.getCostPerKg();
    }
}
