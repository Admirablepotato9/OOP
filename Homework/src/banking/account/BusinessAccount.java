package banking.account;

import banking.account.Exceptions.AccountException;
import banking.transaction.interfaces.TransactionEnum;

public class BusinessAccount extends AbstractAccount {

    private static final double MINIMUM_BALANCE = 5000;
    private static final double OPEN_FEE = 100;
    private static final double MAINTENANCE_FEE = 50;

    public BusinessAccount(String accountNumber, String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        super(accountNumber, 0, OPEN_FEE, MAINTENANCE_FEE);
        if (initialBalance < (OPEN_FEE + MAINTENANCE_FEE + MINIMUM_BALANCE)) {
            throw new AccountException("Initial balance must cover open fee, maintenance fee, and minimum balance.");
        }
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.balance = initialBalance - OPEN_FEE - MAINTENANCE_FEE;
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) {
        // Account creation logic is handled in the constructor
    }

    @Override
    public double withdraw(double amount) {
        if ((this.balance - amount) < MINIMUM_BALANCE) {
            throw new AccountException("Withdrawal would bring balance below minimum required balance.");
        }
        this.balance -= amount;
        Transaction transaction = new Transaction(TransactionEnum.WITHDRAWAL, "Withdrawal", amount);
        this.movements.put(transaction.getId(), transaction);
        return this.balance;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if ((this.balance - amount) < MINIMUM_BALANCE) {
            throw new AccountException("Transfer would bring balance below minimum required balance.");
        }
        if (!isValidConcept(concept)) {
            throw new AccountException("Invalid transaction concept for Business Account.");
        }
        this.balance -= amount;
        Transaction transaction = new Transaction(TransactionEnum.CHARGES, concept, amount);
        this.movements.put(transaction.getId(), transaction);
        return this.balance;
    }

    private boolean isValidConcept(String concept) {
        try {
            BusinessCategoryEnum.valueOf(concept.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        try {
			return "BusinessAccount{" +
			        "accountNumber='" + getAccountNumber() + '\'' +
			        ", name='" + getName() + '\'' +
			        ", email='" + getEmail() + '\'' +
			        ", phoneNumber='" + getPhoneNumber() + '\'' +
			        ", balance=" + getBalance() +
			        '}';
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void InitAccount(String name, String email, String phoneNumber, double initialBalance) {
		// TODO Auto-generated method stub
		
	}
   
}
