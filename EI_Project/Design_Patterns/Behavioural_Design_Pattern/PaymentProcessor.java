/*2. Strategy Pattern
Use Case: Payment Gateway
In this system, we have a payment gateway that supports multiple payment methods 
(e.g., credit card, PayPal, and bank transfer). 
We want to decouple the payment method from the payment processor to make it easier to add new payment methods in the future.*/

import java.util.Scanner;

// Strategy (Payment Method)
interface PaymentMethod {
    void pay(double amount);
}

class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card");
    }
}

class PayPal implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class BankTransfer implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using bank transfer");
    }
}

// Context (Payment Processor)
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Bank Transfer");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            System.out.println("Enter the amount to pay:");
            double amount = scanner.nextDouble();

            PaymentMethod paymentMethod = null;

            switch (choice) {
                case 1:
                    paymentMethod = new CreditCard();
                    break;
                case 2:
                    paymentMethod = new PayPal();
                    break;
                case 3:
                    paymentMethod = new BankTransfer();
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            PaymentProcessor paymentProcessor = new PaymentProcessor(paymentMethod);
            paymentProcessor.processPayment(amount);
        }

        scanner.close();
    }
}
