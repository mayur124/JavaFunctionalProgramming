package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer shreeji = new Customer("Shreeji", "9856445521");

        System.out.println("// Without consumer");
        greetCustomer(shreeji);

        System.out.println("// With Consumer");
        greetCustomerConsumer.accept(shreeji);

        System.out.println("// With BiConsumer");
        greetCustomerBiConsumer.accept(shreeji, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello, " + customer.name + ".\nThank you for registering " + customer.phoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer
            -> System.out.println("Hello, " + customer.name + ".\nThank you for registering " + customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNum)
            -> System.out.println("Hello, " + customer.name + ".\nThank you for registering " + (showPhoneNum ? customer.phoneNumber : "*****"));

    static class Customer {
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
