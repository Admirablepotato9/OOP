package banking.account;

import banking.account.Exceptions.AccountException;
import banking.transaction.interfaces.TransactionEnum;

public class SavingsAccount extends AbstractAccount {

    private static final double INTEREST_RATE = 0.15;
    private static final double MAX_WITHDRAWAL_LIMIT = 500;
    private static final int MAX_WITHDRAWALS = 2;
    private static final double OPEN_FEE = 0;
    private static final double MAINTENANCE_FEE = 0;
    private int withdrawalsCount = 0;

    public SavingsAccount(String accountNumber, String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        super(accountNumber, 0, OPEN_FEE, MAINTENANCE_FEE);
        if (initialBalance < OPEN_FEE) {
            throw new AccountException("Initial balance must cover open fee.");
        }
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.balance = initialBalance - OPEN_FEE;
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) {
        // Account creation logic is handled in the constructor
    }

    @Override
    public double withdraw(double amount) {
        if (withdrawalsCount >= MAX_WITHDRAWALS) {
            throw new AccountException("Maximum number of withdrawals exceeded.");
        }
        if (amount > MAX_WITHDRAWAL_LIMIT) {
            throw new AccountException("Amount exceeds maximum withdrawal limit.");
        }
        withdrawalsCount++;
        this.balance -= amount;
        Transaction transaction = new Transaction(TransactionEnum.WITHDRAWAL, "Withdrawal", amount);
        this.movements.put(transaction.getId(), transaction);
        return this.balance;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        throw new AccountException("Transfers are not allowed for Savings Account.");
    }

    public double estimateInterest(int days) {
        return this.balance * Math.pow(1 + INTEREST_RATE / 365, days) - this.balance;
    }

    @Override
    public String toString() {
        try {
			return "SavingsAccount{" +
			        "accountNumber='" + getAccountNumber() + '\'' +
			        ", name='" + getName() + '\'' +
			        ", email='" + getEmail() + '\'' +
			        ", phoneNumber='" + getPhoneNumber() + '\'' +
			        ", balance=" + getBalance() +
			        ", estimatedInterest=" + estimateInterest(365) + // Example for 1 year
			        '}';
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

	@Override
	public void InitAccount(String name, String email, String phoneNumber, double initialBalance) {
		// TODO Auto-generated method stub
		
	}
}
