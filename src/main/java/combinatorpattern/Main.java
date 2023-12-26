package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "ALice",
                "alice@gmail.com",
                "+099999999",
                LocalDate.of(2020, 1, 1));

        System.out.println(new CustomerValidatorService().isValid(customer));

        // using combinator pattern

        ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAdult()).apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
