import java.util.*;

public class KFrequentNumbers {

    static void print_N_mostFrequentNumbers(int[] arr, int N, int K) {
        int[] frequencyArray = new int[1001]; // Assuming the range of numbers is from 0 to 1000

        // Count the frequency of each number
        for (int i = 0; i < N; i++) {
            frequencyArray[arr[i]]++;
        }

        // Create a list of unique numbers with their frequencies
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                uniqueNumbers.add(i);
            }
        }

        // Sort the list based on frequency and then on the key in descending order
        uniqueNumbers.sort((num1, num2) -> {
            if (frequencyArray[num1] == frequencyArray[num2]) {
                return num2 - num1;
            } else {
                return frequencyArray[num2] - frequencyArray[num1];
            }
        });

        // Print the top K frequent numbers
        System.out.print(K + " numbers with most occurrences are: ");
        for (int i = 0; i < K && i < uniqueNumbers.size(); i++) {
            System.out.print(uniqueNumbers.get(i) + " ");
        }
    }

    // Driver's Code
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int N = arr.length;
        int K = 2;

        // Function call
        print_N_mostFrequentNumbers(arr, N, K);
    }
}
