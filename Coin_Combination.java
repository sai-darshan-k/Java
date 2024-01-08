import java.util.*;

class Denomination_Sum extends Thread
{
    private int coins[];
    private int result[];
    private int coin_sum;

    public Denomination_Sum(int coins[],int coin_sum) //Constructor Definiton
    {
        this.coins = coins;
        this.coin_sum = coin_sum;
        this.result = new int[coin_sum + 1];
    }

    @Override
    public void run() // Thread run method to get the combinations
    {
        findCombinations();
    }

    public void findCombinations()
    {
        //Initialsing the result array
        result[0] = 1;
        for(int coin: coins)
        {
            for(int j = coin; j <= coin_sum; j++)
            {
                result[j] += result[j - coin];
            }
        }
    }

    public int getResult()
    {
        return result[coin_sum];
    }
}

class Input extends Thread {
    private int N;
    private int sum;
    private int[] coins;

    public void run() {
        // Take user input for the number of coins, sum, and coin denominations
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of coins: ");
        N = scanner.nextInt();
        System.out.print("Enter the target sum: ");
        sum = scanner.nextInt();
        coins = new int[N];
        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public int getSum() {
        return sum;
    }

    public int[] getCoins() {
        return coins;
    }
}

public class Coin_Combination
{
    public static void main(String[] args) throws InterruptedException
    {
        //Creating instance of Input Class to get the inputs
        Input input = new Input();
        input.start();

        //Method for the thread to finish the input operation thread and then proceed for calcultion
        input.join();

        // Extract input from the first thread
        int sum = input.getSum();
        int[] coins = input.getCoins();

        //Creating instance of the second thread class 
        Denomination_Sum deno_sum = new Denomination_Sum(coins,sum);
        deno_sum.start();

        try {
            // Wait for the Combination thread to finish
            deno_sum.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the result
        System.out.println("Number of ways to make the sum " + sum +
                " with coins " + Arrays.toString(coins) + ": " + deno_sum.getResult());
    }
}