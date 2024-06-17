package exam2;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String fullName, String address, String phoneNumber, String email) throws UserException {
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public void setFullName(String fullName) throws UserException {
        if (!fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new UserException("Invalid full name. Only letters and spaces are allowed.");
        }
        this.fullName = fullName;
    }

    public void setAddress(String address) throws UserException {
        if (!address.matches(".*\\d{5}.*\\b(OAX|QROO|MOR|QRO|SIN)\\b.*")) {
            throw new UserException("Invalid address. Must contain a 5 digit postal code and state alias.");
        }
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException {
        if (!phoneNumber.matches("^\\+52\\d{10}$")) {
            throw new UserException("Invalid phone number. Must start with +52 and have exactly 10 digits after that.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws UserException {
        if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            throw new UserException("Invalid email. Must be a @gmail.com email address.");
        }
        this.email = email;
    }
}