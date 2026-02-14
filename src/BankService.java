import java.util.*;

public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void createAccount(int accNo, String name, double balance) {
        Account account = new Account(accNo, name, balance);
        accounts.put(accNo, account);
        System.out.println("Account created successfully.");
    }

    public Account getAccount(int accNo) {
        return accounts.get(accNo);
    }

    public void transferMoney(int fromAcc, int toAcc, double amount) {

        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (sender.withdraw(amount)) {
            receiver.deposit(amount);

            transactions.add(new Transaction(fromAcc, "Debit", amount));
            transactions.add(new Transaction(toAcc, "Credit", amount));

            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
