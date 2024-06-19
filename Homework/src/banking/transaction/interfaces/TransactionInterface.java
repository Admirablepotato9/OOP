package banking.transaction.interfaces;

public interface TransactionInterface {
    String getId();
    TransactionEnum getTransactionType();
    String getConcept();
    double getAmount();
}
