package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    // static method in an interface is the new feature of Java8 which can be called without an object
    // default method is also a new feature of Java8 which can be used for backward compatibility
    //      i.e. if already interface is implemented on some class then if we want to add some more method(s) to interface
    //      then new method(s) will be needed to implement in those classes.
    //      To prevent error in class which have implemented an interface, default method(s) can be created.

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmailId().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+91") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
