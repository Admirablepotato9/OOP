package banking.transaction;
import java.util.UUID;

import banking.transaction.interfaces.TransactionEnum;
import banking.transaction.interfaces.TransactionInterface;

/**
 * Transaction class represents an account transaction.
 */
public class Transaction implements TransactionInterface {

    private String id;
    private TransactionEnum transactionType;
    private String concept;
    private double amount;

    /**
     * Constructs a new Transaction.
     *
     * @param transactionType The type of the transaction.
     * @param concept The description of the transaction.
     * @param amount The amount of the transaction.
     * @throws IllegalArgumentException If the amount has more than 2 decimal places.
     */
    public Transaction(TransactionEnum transactionType, String concept, double amount) throws IllegalArgumentException {
        this.id = generateId();
        this.transactionType = transactionType;
        this.concept = concept;
        setAmount(amount);
    }

    private String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(0, 16);
    }

    private void setAmount(double amount) throws IllegalArgumentException {
        if (Math.round(amount * 100) != amount * 100) {
            throw new IllegalArgumentException("Amount must have at most 2 decimal places.");
        }
        this.amount = amount;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public TransactionEnum getTransactionType() {
        return transactionType;
    }

    @Override
    public String getConcept() {
        return concept;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", transactionType=" + transactionType +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                '}';
    }
}

