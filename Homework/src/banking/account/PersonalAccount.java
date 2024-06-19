package banking.account;

import banking.account.Exceptions.AccountException;
import banking.transaction.interfaces.TransactionEnum;

public class PersonalAccount extends AbstractAccount {

    private static final double MAX_TRANSFER_WITHDRAWAL_LIMIT = 500;
    private static final double MINIMUM_BALANCE = 1000;
    private static final double OPEN_FEE = 2;
    private static final double MAINTENANCE_FEE = 10;

    public PersonalAccount(String accountNumber, String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        super(accountNumber, 0, OPEN_FEE, MAINTENANCE_FEE);
        this.initAccount(name, email, phoneNumber, initialBalance);
    }

    private void initAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        // Account creation logic is handled in the constructor
    	if (initialBalance < (OPEN_FEE + MINIMUM_BALANCE)) {
            throw new AccountException("Initial balance must cover open fee and minimum balance.");
        }
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.balance = initialBalance - OPEN_FEE - MAINTENANCE_FEE;
    }

    @Override
    public double withdraw(double amount) {
        if (amount > MAX_TRANSFER_WITHDRAWAL_LIMIT) {
            throw new AccountException("Amount exceeds maximum withdrawal limit.");
        }
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
        if (amount > MAX_TRANSFER_WITHDRAWAL_LIMIT) {
            throw new AccountException("Amount exceeds maximum transfer limit.");
        }
        if ((this.balance - amount) < MINIMUM_BALANCE) throws AccountException {
            throw new AccountException("Transfer would bring balance below minimum required balance.");
        }
        this.balance -= amount;
        Transaction transaction = new Transaction(TransactionEnum.CHARGES, concept, amount);
        this.movements.put(transaction.getId(), transaction);
        return this.balance;
    }

    @Override
    public String toString() {
        try {
			return "PersonalAccount{" +
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

	@Override
	public void createAccount(String name, String email, String phoneNumber, double initialBalance) {
		// TODO Auto-generated method stub
	}
}
