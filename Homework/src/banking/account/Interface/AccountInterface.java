package banking.account.Interface;

import banking.account.Exceptions.AccountException;

public interface AccountInterface {
    
    /**
     * Creates a new account with the specified details.
     * 
     * @param name The name of the account holder.
     * @param email The email address of the account holder.
     * @param phoneNumber The phone number of the account holder.
     * @param initialBalance The initial balance to be deposited in the account.
     * @throws AccountCreationException If the account cannot be created.
     */
    void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountException;

    /**
     * Retrieves the account number.
     * 
     * @return The account number as a String.
     */
    String getAccountNumber();

    /**
     * Sets or gets the email address of the account holder.
     * 
     * @param email The new email address to set, or null to get the current email.
     * @return true if the email was set successfully, false otherwise.
     * @throws AccountException If there is an error setting or getting the email.
     */
    boolean setEmail(String email) throws AccountException;
    String getEmail() throws AccountException;

    /**
     * Sets or gets the phone number of the account holder.
     * 
     * @param phoneNumber The new phone number to set, or null to get the current phone number.
     * @return true if the phone number was set successfully, false otherwise.
     * @throws AccountException If there is an error setting or getting the phone number.
     */
    boolean setPhoneNumber(String phoneNumber) throws AccountException;
    String getPhoneNumber() throws AccountException;

    /**
     * Sets or gets the name of the account holder.
     * 
     * @param name The new name to set, or null to get the current name.
     * @return true if the name was set successfully, false otherwise.
     * @throws AccountException If there is an error setting or getting the name.
     */
    boolean setName(String name) throws AccountException;
    String getName() throws AccountException;

    /**
     * Retrieves the current balance of the account.
     * 
     * @return The current balance as a double.
     */
    double getBalance();

    /**
     * Withdraws a specified amount from the account.
     * 
     * @param amount The amount to withdraw.
     * @return The new balance after withdrawal.
     * @throws AccountException If there is an error during withdrawal.
     */
    double withdraw(double amount) throws AccountException;

    /**
     * Transfers a specified amount from the account with a given concept.
     * 
     * @param amount The amount to transfer.
     * @param concept The concept or description of the transfer.
     * @return The new balance after the transfer.
     * @throws AccountException If there is an error during the transfer.
     */
    double transfer(double amount, String concept) throws AccountException;

    /**
     * Consults a past transaction by its ID.
     * 
     * @param Id The ID of the transaction to consult.
     * @return The details of the transaction as a String.
     * @throws AccountException If there is an error retrieving the transaction.
     */
    String consultTransaction(String Id) throws AccountException;

	void InitAccount(String name, String email, String phoneNumber, double initialBalance);
}

/**
 * Exception to be thrown during account creation errors.
 */


