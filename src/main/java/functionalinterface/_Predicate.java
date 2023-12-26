package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("07000000"));
        System.out.println(isPhoneNumberValid("09003309900"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidByPredicateFunction.test("07000000000"));
        System.out.println(isPhoneNumberValidByPredicateFunction.test("07000000"));
        System.out.println(isPhoneNumberValidByPredicateFunction.test("09003309900"));

        System.out.println("Is phone number valid and contains 3 = ");
        System.out.println(isPhoneNumberValidByPredicateFunction.and(containsNumber3).test("07000000003"));

        System.out.println("Is phone number valid or contains 3 = ");
        System.out.println(isPhoneNumberValidByPredicateFunction.or(containsNumber3).test("07000000000"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidByPredicateFunction = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
