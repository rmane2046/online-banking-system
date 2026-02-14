import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Online Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Balance");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    bank.createAccount(accNo, name, bal);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account acc = bank.getAccount(accNo);

                    if (acc != null) {
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("From Account: ");
                    int from = sc.nextInt();

                    System.out.print("To Account: ");
                    int to = sc.nextInt();

                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    bank.transferMoney(from, to, amt);
                    break;

                case 4:
                    bank.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
