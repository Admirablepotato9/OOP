package exam2;
import java.time.LocalDateTime;

public abstract class Package {
    private User sender; 
    private User recipient; 

    // Constructor
    public Package(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

   
    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public LocalDateTime getEstimateArrival(double hours) {
        return LocalDateTime.now().plusHours(46);
    }

    /**
     * Estimates the cost of the packagex
     * If we are sending a package the cost is multiplied by the weight of the package.
     * If we are sending a letter the cost is just the price of sending a 1kg package
     * @example: Sending a package of 5kg to QROO: 5 * 3.70 = 18.5
     */
    public abstract double estimatePrice(DistributionPoints destination, double weight);
}
