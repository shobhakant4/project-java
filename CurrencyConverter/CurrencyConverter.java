import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Hardcoded exchange rates
        exchangeRates.put("USD", 1.0); // US Dollar
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.75); // British Pound
        exchangeRates.put("INR", 74.0); // Indian Rupee
        // Add more currencies and their exchange rates as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter");

        while (true) {
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the source currency (e.g., USD, EUR, GBP, INR): ");
            String sourceCurrency = scanner.next().toUpperCase();

            System.out.print("Enter the target currency (e.g., USD, EUR, GBP, INR): ");
            String targetCurrency = scanner.next().toUpperCase();

            if (exchangeRates.containsKey(sourceCurrency) && exchangeRates.containsKey(targetCurrency)) {
                double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
                System.out.printf("%.2f %s = %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);
            } else {
                System.out.println("Invalid currency.");
            }

            System.out.print("Do you want to convert another currency? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using Currency Converter");
        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        // Convert to USD first
        double amountInUSD = amount / sourceRate;
        // Convert from USD to target currency
        return amountInUSD * targetRate;
    }
}
