import java.util.Arrays;

abstract class Robber {
    public abstract int rowHouses(int x[]);
    public abstract int roundHouses(int x[]);
    public abstract int squareHouse(int x[]);
    public abstract int multiHouse(int x[][]);

    public Robber() {
        System.out.println("MScAIML");
    }

    public void machineLearning() {
        System.out.println("I love Machine Learning");
    }
}

public class JavaProfessionalRobbery extends Robber {
    @Override
    public int squareHouse(int x[]) {
        return common(x);
    }

    @Override
    public int rowHouses(int x[]) {
        return common(x) > x[0] + x[3] ? common(x) : x[0] + x[3];
    }

    @Override
    public int roundHouses(int x[]) {
        return common(x);
    }

    @Override
    public int multiHouse(int x[][]) {
        if (x.length != 4 || x[0].length != 4) {
            throw new IllegalArgumentException("Only 4 houses accepted!");
        }
        return common(x[0]);
    }

    private int common(int x[]) {
        if (x.length != 4) {
            throw new IllegalArgumentException("Only 4 houses accepted!");
        }
        int a = x[0] + x[2];
        int b = x[1] + x[3];
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        JavaProfessionalRobbery ob = new JavaProfessionalRobbery();
        int a[] = {1, 2, 3, 0};
        int b[] = {1, 2, 3, 4};
        int c[] = {5, 10, 2, 7};
        int d[][] = {{5, 3, 8, 2}, {10, 12, 7, 6}, {4, 9, 11, 5}, {8, 6, 3, 7}};

        System.out.println("For square houses: " + ob.squareHouse(a));
        System.out.println("For round houses: " + ob.roundHouses(b));
        System.out.println("For row houses: " + ob.rowHouses(c));
        System.out.println("For multi houses: " + ob.multiHouse(d));
    }
}
