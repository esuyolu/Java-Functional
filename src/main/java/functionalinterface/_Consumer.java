package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999999");

        // normal java function
        greetCustomer(maria);

        // Consumer Functional interface
        greetCustomerByConsumerFunction.accept(maria);

        // BiConsumer Functional interface
        greetCustomerByConsumerFunctionV2.accept(maria, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerByConsumerFunctionV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    " ,thanks for registering phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "********"));

    static Consumer<Customer> greetCustomerByConsumerFunction = customer ->
            System.out.println("Hello " + customer.customerName +
            " ,thanks for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                " ,thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
