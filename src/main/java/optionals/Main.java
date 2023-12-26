package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Object value = Optional.ofNullable(null).orElseGet(() -> "default value");

        Object value2 = Optional.ofNullable("hello").orElseThrow(() -> new IllegalStateException("exception"));

        Optional.ofNullable("hello")
                .ifPresent(System.out::println);

        System.out.println(value);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("sending email to " + email),
                        () -> System.out.println("cannot send email"));
    }
}
