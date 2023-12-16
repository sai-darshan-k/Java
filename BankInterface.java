// Bank Interface
interface BankInterface {
    double getBalance();
    double getInterestRate();
}

// BankA class implementing BankInterface
class BankA implements BankInterface {
    private double balance;

    public BankA(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0.07; // 7% interest rate for BankA
    }
}

// BankB class implementing BankInterface
class BankB implements BankInterface {
    private double balance;

    public BankB(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0.074; // 7.4% interest rate for BankB
    }
}

// BankC class implementing BankInterface
class BankC implements BankInterface {
    private double balance;

    public BankC(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0.079; // 7.9% interest rate for BankC
    }
}

// Main class to demonstrate the functionality
public class BankInterface {
    public static void main(String[] args) {
        // Deposit amounts into banks
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        // Display balance and interest rate for each bank
        System.out.println("Bank A:");
        System.out.println("Balance: $" + bankA.getBalance());
        System.out.println("Interest Rate: " + (bankA.getInterestRate() * 100) + "%\n");

        System.out.println("Bank B:");
        System.out.println("Balance: $" + bankB.getBalance());
        System.out.println("Interest Rate: " + (bankB.getInterestRate() * 100) + "%\n");

        System.out.println("Bank C:");
        System.out.println("Balance: $" + bankC.getBalance());
        System.out.println("Interest Rate: " + (bankC.getInterestRate() * 100) + "%");
    }
}
