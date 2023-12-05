import java.util.Scanner;
import java.util.Random;
//Guessing game where you guess from 1 - 100

public class ATLab4
{
     
   public static void main(String[] args)
   {
      int bestGuess = 10000000; //Random big number to help record a high score (lowest number)
      int gameCount = 0; //Records amt of games played within a session

      int numTries = 0; //Records number of tries user takes to guess the right number in 1 game
      int totalNumTries = 0; //Adds up all total guesses within a game session
      double guessPerGame = 0.0; //Variable that takes the average amt of guesses per game
      
      GameRules(); //Prints out the rules for how game works
      System.out.println("Do you want to play a game?");
      Scanner question = new Scanner(System.in); //Scanner the expects the user if they want to play the game or not
      String answer = question.next();
      if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y'){ //if answer starts with the letter y or Y, then game starts
         numTries = PlayGame(); // PlayGame returns the amount of guesses. numTries records that value
         totalNumTries += numTries; //numTries is tallied up into totalNumTries
         gameCount++; //gameCount increment after each game is done
         if(numTries < bestGuess){
            bestGuess = numTries; //bestGuess becomes the lowest score of the session that you have. 
         }
      }
      
      boolean continuePlay = true;
      
      
      while(continuePlay == true){ //while loop that continues playing if continuePlay is true. only true if user input gives an answer that starts with y or Y.
         System.out.println("Do you want to play again?");
         Scanner questionAgain = new Scanner(System.in);
         String answerAgain = questionAgain.next();
           if(answerAgain.charAt(0) == 'y' || answerAgain.charAt(0) == 'Y'){
            numTries = PlayGame();
            totalNumTries += numTries;
            gameCount++;
            if(numTries < bestGuess){
               bestGuess = numTries;
            }
            System.out.println(totalNumTries);
         
      }
         else if(answerAgain.charAt(0) == 'n' || answerAgain.charAt(0) == 'N'){ //when user input starts with n or N (for no), loop is done
            continuePlay = false;
            ReportGame(gameCount, totalNumTries, guessPerGame, bestGuess);
         }

      }     

}
public static int PlayGame(){
   int counter = 0; //counter for the amount of guesses
   int keepGuessing = 9999; //allows the user 9999 tries to get the correct guess
   int guess = 0; //takes the current guess that later compares if its the correct guess, too low, or too high.
   Random rand = new Random(); //generates a random number object
   
   int randomNum = rand.nextInt(100) + 1; //takes the random number from 1 to 100
      System.out.println("Choose a number between 1-100");
      while(keepGuessing > 0){ //game keeps running for 9999 tries
      Scanner input = new Scanner(System.in); //takes in user input for a guess
      System.out.print("Your guess?: "); 
      guess = input.nextInt();
      
      if(guess > randomNum){
         System.out.println("It's lower.");
         counter++;
      }      
      else if(guess < randomNum){
         System.out.println("It's higher.");
         counter++;
      }
      else{
         counter++;
         System.out.println("You got it right in " + counter + " guesses");
         break; //if user guesses the right answer, then it breaks out of the while loop
      }
      keepGuessing--;
      }
      
      return counter; //counter is returned, which takes the amount of guesses it took to get the right answer for this 1 game
      
   
   }
   
public static void ReportGame(int gameCount, int totalNumTries, double guessPerGame, int bestGuess){ //records the score of the game at the end
         guessPerGame = (double) totalNumTries / gameCount; //guessPerGame gives the double with decimal points

         
         System.out.println("Overall results:");
         System.out.println("Total games = " + gameCount); //shows amount of games in the session
         System.out.println("Total Guesses = " + totalNumTries); //shows total amount of tries in the session
         System.out.printf("%s%.1f%n", "Average Guesses Per Game = ", guessPerGame); //shows average guesses per game in the session
         System.out.println("Best game = " + bestGuess); //shows the best score (lowest score) in the session
}
public static void GameRules(){
      System.out.println("This program allows you to play a guessing game.\nI will think of a number between 1 and\n100 and will allow you to guess until\nyou get it. For each guess. I will tell you\nwhether the right answer is higher or lower\nthan your guess.");
      System.out.println(); //prints the rules of the game
}

}

