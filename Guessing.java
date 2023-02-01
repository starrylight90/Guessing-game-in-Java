import java.util.*;

public class Guessing{

    static int computerGuess(final int lowval, final int highval, final int randnum, int count){
        if(highval >= lowval){
            final int guess = lowval + (highval - lowval) /2;

            if(guess == randnum){
                return count;
            }
            if(guess > randnum ){
                count++;
                return (computerGuess(lowval, guess-1, randnum, count));
            } else{
                count++;
                return(computerGuess(guess+1, highval, randnum, count));
            }
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args){
        
        int guess = -99;
        int count = 0;
        final Scanner input = new Scanner(System.in);
        

        // generate random number between 1 and 100
        final int randnum = (int)(Math.random() * 100 + 1);

        while(guess!=randnum){
            System.out.println("Enter a guess between 1 and 100: ");
        guess = input.nextInt();

        if (guess < randnum){
            System.out.println("Higher");
        }
        else if(guess > randnum){
            System.out.println("Lower");
        }
        else{
            System.out.println("You guessed it!!");
            break;
        }
        count++;
    } //end of the while loop
    input.close();
    System.out.println("You took " + count + " steps to guess it");
    System.out.println("Computer took "+ computerGuess(0, 100, randnum, 0)+" steps to guess it");
    }
}