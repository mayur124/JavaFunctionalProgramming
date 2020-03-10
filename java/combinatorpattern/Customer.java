package combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private final String emailId;
    private final LocalDate dob;

    public Customer(String name, String phoneNumber, String emailId, LocalDate dob) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public LocalDate getDob() {
        return dob;
    }
}
