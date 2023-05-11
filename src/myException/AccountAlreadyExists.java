package myException;

public class AccountAlreadyExists extends Exception {
    public AccountAlreadyExists(String message) {
        super(message);
    }
}
