public class AlphabetWarGame 
{
    private static int Left_Values_Strengths[] = {8,6,4,2};
    private static int Right_Values_Strengths[] = {8,6,4,2};

    //Default Constructor
    public AlphabetWarGame(){};

    //Constructor for value customisation
    public AlphabetWarGame(int[] New_Left_Values_Strengths, int[] New_Right_Values_Strengths)
    {
        if(New_Left_Values_Strengths.length == 4 && New_Right_Values_Strengths.length == 4)
        {
            Left_Values_Strengths = New_Left_Values_Strengths;
            Right_Values_Strengths = New_Right_Values_Strengths;
        }
        else
        {
            System.out.println("Array Lengths don't match. Default values will be taken.");
        }
    }

    private int getLeftStrength(char letter) {
        switch (letter) {
            case 'w':
                return Left_Values_Strengths[0];
            case 'p':
                return Left_Values_Strengths[1];
            case 'b':
                return Left_Values_Strengths[2];
            case 's':
                return Left_Values_Strengths[3];
            default:
                return 0;
        }
    }

    private int getRightStrength(char letter) {
        switch (letter) {
            case 'm':
                return Right_Values_Strengths[0];
            case 'q':
                return Right_Values_Strengths[1];
            case 'd':
                return Right_Values_Strengths[2];
            case 'z':
                return Right_Values_Strengths[3];
            default:
                return 0;
        }
    }

    public String alphabets_fight(String leftWord, String rightWord) {
        int leftStrength = calculateTotalStrength(leftWord, Left_Values_Strengths);
        int rightStrength = calculateTotalStrength(rightWord, Right_Values_Strengths);

        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (leftStrength < rightStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    private int calculateTotalStrength(String word, int[] strengths) {
        int totalStrength = 0;
        char[] letters = word.toCharArray();
        
        for (int i = 0; i < letters.length; i++) {
            totalStrength += getLeftStrength(letters[i]);
        }
    
        return totalStrength;
    }

    public String alphabets_fight(String input) {
        int total_strengths_left = 0;
        int total_strengths_right = 0;
    
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            int strengths_left = getLeftStrength(letter);
            int strengths_right = getRightStrength(letter);
    
            total_strengths_left += strengths_left;
            total_strengths_right += strengths_right;
        }
    
        if (total_strengths_left > total_strengths_right) {
            return "Left side wins!";
        } else if (total_strengths_left < total_strengths_right) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String args[])
    {
        AlphabetWarGame war_game = new AlphabetWarGame();
        
        // Test cases
        System.out.println(war_game.alphabets_fight("z"));            // Right side wins!
        System.out.println(war_game.alphabets_fight("zdqmwpbs"));      // Let's fight again!
        System.out.println(war_game.alphabets_fight("wwwwwwz"));       // Left side wins!
    }
}