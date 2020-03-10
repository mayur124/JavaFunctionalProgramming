package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    public boolean isCustomerValid(Customer customer) {
        return  isEmailValid(customer.getEmailId()) &&
                isAdult(customer.getDob()) &&
                isPhoneNumberValid(customer.getPhoneNumber());
    }
}
