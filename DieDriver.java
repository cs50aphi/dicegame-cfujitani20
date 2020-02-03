import java.util.Scanner;
public class DieDriver
{
    public static void main(String[] args)
    {
        boolean gameOver = false;
        int goal = 150;
        int location1 = 0;
        int location2 = 0;
        int sides = 6;
        int diecounter1 = 0;
        int diecounter2 = 0;
        // Create players p1 and p2
        Die p1 = new Die();
        Die p2 = new Die();
        // create triple roll markers
        Die tripleroll1 = new Die();
        Die tripleroll2 = new Die();
        Die checkpoint1 = new Die();
        Die checkpoint2 = new Die();
        // intialize checkpoints for multiplier rolls
        int tempgoal1 = checkpoint1.randomize();
        int tempgoal2 = checkpoint2.randomize();
        int triplerollgoal1 = tripleroll1.randomize();
        int triplerollgoal2 = tripleroll2.randomize();
        // int numberofrolls1 = doubleroll1.roll(1,10);
        // int numberofrolls2 = doubleroll2.roll(1,10);
        // While gameOver is false
        while (!gameOver)
        {
            // report location1
            System.out.println("Player 1 is at " + location1);
            System.out.println("Player 2 is at " + location2);
            pause();
            // roll for p1
            int temp = p1.roll();
            int temp2 = p2.roll();
            System.out.println(triplerollgoal1);
            System.out.println(triplerollgoal2);
            // check to see if p1 has won
            // if p1 has won, set gameOver to true
            if (location1 + temp == goal)
            {
                System.out.println("Player 1 wins!");
                location1 += temp;
                gameOver = true;
            }
            // check if player reaches the randomized checkpoint then modify roll
            else if (location1 == tempgoal1)
            {

                System.out.println("Player 1 rolled a " + temp + " and hit " + tempgoal1 + " and gets a 3x multiplier!");
                location1 += temp * (sides / 2);
            }
            // check if player hits triple roll number and give a triple role to player 1
            else if (location1 == triplerollgoal1)
            {
                System.out.println("Player 1 rolled to " + location1 + " and gets a triple roll this turn!");
                for (int i = 0; i < 3; i++)
                {
                    int temptriple1 = p1.roll();
                    location1 += temptriple1;
                }
            }
            // add the die to the current total, and make sure that it is less than goal
            else if (location1 + temp < goal)
            {
                System.out.println("Player 1 rolls a " + temp);
                location1 += temp;
            }
            // if it exceeds 200 then do nothing and tell the player that they went over
            else
            {
                System.out.println("Player 1 rolled a " + temp + " and exceeds the goal. So it adds nothing. :(");
            }
            if (!gameOver)
            {
                // if player 2 total = 100 then gameOver = true
                if (location2 + temp2 == goal)
                {
                    System.out.println("Player 2 wins!");
                    location2 += temp2;
                    gameOver = true;
                }
                // check if player hits triple roll number and give a triple role to player 2
                else if (location2 == triplerollgoal2)
                {
                    System.out.println("Player 2 rolled to " + location2 + " and gets a triple roll this turn!");
                    for (int i = 0; i < 3; i++)
                    {
                        int temptriple2 = p2.roll();
                        location2 += temptriple2;
                    }
                }
                // if player 2 total matches the randomized checkpoint then modify roll
                else if (location2 == tempgoal2)
                {
                    System.out.println("Player 2 rolled a " + temp + " and hit " + location2 + " and gets a 3x multiplier!");
                    location2 += temp2 * (sides / 2);
                }
                // add player 2's roll to the current total and make sure it is below 100
                else if (location2 + temp2 < goal)
                {
                    System.out.println("Player 2 rolls a " + temp2);
                    location2 += temp2;
                }
                // if player 2 roll exceeds 100 then do nothing and tell player that is above
                else
                {
                    System.out.println("Player 2 rolled a " + temp2 + " and exceeeds the goal. So it adds nothing. :(");
                }
            }

        }
        // if not gone over,
        // add roll to location1
        // do same for p2
        // Scanner kb = new Scanner(System.in);
        // System.out.print("How many sides? ");
        // int sides = kb.nextInt();
        // Die d = new Die(sides);
        // int roll = d.roll();
        // System.out.println("You rolled a " + roll);
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to continue");
        in.nextLine();

    }
}