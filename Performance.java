import java.util.Scanner;

public class Performance 
{
    int[] marks;
    
    Performance()
    {
        marks = new int[10];
    }

    public void readMarks()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks for 10 students:");
        for(int i=0; i < 10; i++)
        {
            marks[i] = sc.nextInt();
        }
        sc.close();
    }

    public int highestMark()
    {
        int max = marks[0];
        int i = 0;
        while(i < 10)
        {
            if(marks[i] > max)
            {
                max = marks[i];
            }
            i++;
        }
        return max;
    }

    public int leastMark()
    {
        int min = marks[0];
        int i = 0;
        while(i < 10)
        {
            if(marks[i] < min)
            {
                min = marks[i];
            }
            i++;
        }
        return min;
    }

    int getMode()
    {
        int modeval = 0;
        int maxCount = 0;
        for (int i = 0; i < marks.length; i++) {
            int count = 0;
            for (int j = 0; j < marks.length; j++) {
                if (marks[j] == marks[i]) {
                    count++;
                }
            }
            if (count > maxCount || (count == maxCount && marks[i] > modeval)) {
                maxCount = count;
                modeval = marks[i];
            }
        }
        return modeval;
    }

    public int getFreqAtMode() {
        int mode = getMode();
        int freq = 0;
        for (int i = 0; i < marks.length; i++) {
            int mark = marks[i];
            if (mark == mode) {
                freq++;
            }
        }
        return freq;
    }

    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }

    public static void main(String args[])
    {
        Performance p1 = new Performance();
        p1.readMarks();
        p1.display();
    }
}