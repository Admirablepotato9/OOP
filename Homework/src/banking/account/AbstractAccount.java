package banking.account;

import java.util.HashMap;
import java.util.regex.Pattern;

import banking.account.Exceptions.AccountException;
import banking.account.Interface.AccountInterface;
import banking.transaction.interfaces.TransactionEnum;

/**
 * AbstractAccount provides a base implementation of the AccountInterface,
 * handling common account operations and validations.
 */
public abstract class AbstractAccount implements AccountInterface {

    // Private parameters
    private double accountLimit;
    private double openFee;
    private double maintenanceFee;
    protected HashMap<String, Transaction> movements = new HashMap<>();
    
    // Private attributes
    private String accountNumber;
    private String name;
    private String email;
    private String phoneNumber;
    protected double balance;

    // Email validation regex pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    // Phone number validation regex pattern (e.g., US phone numbers)
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^[0-9]{10}$");
    
    // Constructors, getters, and setters for private parameters
    public AbstractAccount(String accountNumber, double accountLimit, double openFee, double maintenanceFee) {
        this.accountNumber = accountNumber;
        this.accountLimit = accountLimit;
        this.openFee = openFee;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public boolean setEmail(String email) throws AccountException {
        if (EMAIL_PATTERN.matcher(email).matches()) {
            this.email = email;
            return true;
        } else {
            throw new AccountException("Invalid email format.");
        }
    }

    @Override
    public String getEmail() throws AccountException {
        if (this.email != null) {
            return this.email;
        } else {
            throw new AccountException("Email is not set.");
        }
    }

    @Override
    public boolean setPhoneNumber(String phoneNumber) throws AccountException {
        if (PHONE_PATTERN.matcher(phoneNumber).matches()) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            throw new AccountException("Invalid phone number format.");
        }
    }

    @Override
    public String getPhoneNumber() throws AccountException {
        if (this.phoneNumber != null) {
            return this.phoneNumber;
        } else {
            throw new AccountException("Phone number is not set.");
        }
    }

    @Override
    public boolean setName(String name) throws AccountException {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
            return true;
        } else {
            throw new AccountException("Invalid name.");
        }
    }

    @Override
    public String getName() throws AccountException{
        if (this.name != null) {
            return this.name;
        } else {
            throw new AccountException("Name is not set.");
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String consultTransaction(String Id) throws AccountException {
        Transaction transaction = movements.get(Id);
        if (transaction != null) {
            return transaction.toString();
        } else {
            throw new AccountException("Transaction not found.");
        }
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract void InitAccount(String name, String email, String phoneNumber, double initialBalance);

    @Override
    public abstract double withdraw(double amount);

    @Override
    public abstract double transfer(double amount, String concept);
}

/**
 * Transaction class represents a financial transaction in the account.
 */
class Transaction {
    private String id;
    private double amount;
    private String concept;
    private String date; // Simplified for this example

    public Transaction(String id, double amount, String concept, String date) {
        this.id = id;
        this.amount = amount;
        this.concept = concept;
        this.date = date;
    }

	public Transaction(TransactionEnum withdrawal, String string, double amount2) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", concept='" + concept + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
