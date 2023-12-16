// WaterConservationSystem.java

// Water Conservation System Interface
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

// Abstract class implementing WaterConservationSystem
abstract class RainySeasonConservation implements WaterConservationSystem {
    // Common methods or properties can be added here
}

// Concrete class extending RainySeasonConservation
class CityBlockConservation extends RainySeasonConservation {

    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;

        if (n <= 2) {
            // Not enough blocks to trap water
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Calculate the maximum height to the left of each block
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Calculate the maximum height to the right of each block
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        int trappedWater = 0;

        // Calculate trapped water for each block
        for (int i = 0; i < n; i++) {
            trappedWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - blockHeights[i]);
        }

        return trappedWater;
    }
}

// Test class for Water Conservation System
public class WaterConservationSystem {
    public static void main(String[] args) {
        // Test Case 1
        int[] blocks1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        WaterConservationSystem system1 = new CityBlockConservation();
        System.out.println("Test Case 1: " + system1.calculateTrappedWater(blocks1)); // Output: 6

        // Test Case 2
        int[] blocks2 = {3, 0, 2, 0, 4};
        WaterConservationSystem system2 = new CityBlockConservation();
        System.out.println("Test Case 2: " + system2.calculateTrappedWater(blocks2)); // Output: 7
    }
}
