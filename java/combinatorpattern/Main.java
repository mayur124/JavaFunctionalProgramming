package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Shreeji",
                "+918745663321",
                "shreeji@akshardham.com",
                LocalDate.of(1781,4,3));

        // System.out.println(new CustomerValidationService().isCustomerValid(customer));

        CustomerRegistrationValidator.ValidationResult validationResult =
                CustomerRegistrationValidator.isAnAdult()
                .and(CustomerRegistrationValidator.isEmailValid())
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .apply(customer);

        if (validationResult == CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            System.out.println(validationResult);
        } else {
            throw new IllegalStateException(validationResult.name());
        }
    }
}
