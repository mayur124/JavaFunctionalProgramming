package FunctionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("// Without Predicate");
        System.out.println(isPhoneNumberValid("915465223365"));
        System.out.println(isPhoneNumberValid("5465223365"));

        System.out.println("// With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("915465223365"));
        System.out.println(isPhoneNumberValidPredicate.test("5465223365"));
        System.out.println("IsPhoneNumValid && IsPhoneNumContains3? " +
                isPhoneNumberValidPredicate.and(isPhoneNumberContains3Predicate).test("5465223365"));
        System.out.println("IsPhoneNumValid || IsPhoneNumContains3? " +
                isPhoneNumberValidPredicate.or(isPhoneNumberContains3Predicate).test("915465223365"));

        // BiPredicate is also another Functional interface which takes two input arguments and returns boolean value based on condition
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("91") && phoneNumber.length() == 12;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("91") && phoneNumber.length() == 12;

    static Predicate<String> isPhoneNumberContains3Predicate = phoneNumber -> phoneNumber.contains("3");
}
