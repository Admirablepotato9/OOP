package banking.account.Exceptions;

public class AccountException extends Exception {
 
 //Default constructor for AccountException.
  
 public AccountException() {
     super();	
 }
 	//Constructor for AccountException with a custom error message.
 public AccountException(String message) {
     super(message);
 }
                 
 // Constructor for AccountException with a custom error message and a cause.
 public AccountException(String message, Throwable cause) {
     super(message, cause);
 }

 //Constructor for AccountException with a cause.
 public AccountException(Throwable cause) {
     super(cause);
 }
}
	