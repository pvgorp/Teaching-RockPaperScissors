package nl.tue.apom.l3;

import java.util.Scanner;

import nl.tue.apom.l3.ai.AutomaticPlayer;
import nl.tue.apom.l3.ai.AutomaticPlayerV2;
import nl.tue.apom.l3.items.*;

/**
 * Reasonably realistic rock/paper/scissors game: taking one player input 
 * and comparing it against a random computer pick until one of both wins.
 * 
 * Opposed to V3, in this variant the human is playing against the AutomaticPlayerV2,
 * so the human can predict the behavior of the bot (since that one makes predictable counter-attacks)
 * 
 * @author pvgorp
 *
 */
public class GameV7 {

  private enum GameResult {
    UNDECIDED, P1WON, P2WON, TIE
  }

  public static void main(String[] args) {
    String howto = "Please enter once one of {paper,rock,scissors} to play"; 
    System.out.println(howto);
    Scanner s = new Scanner(System.in);
    Item i1 = null;
    Item i2 = null;
    AutomaticPlayer player2= new AutomaticPlayerV2(); // ONLY DIFFERENCE TO V3 
    GameResult result = GameResult.UNDECIDED;
    int round= 1;
    do {
      System.out.println("Round "+round++);
      do {
        try {
          System.out.println("Player 1: please enter your choice");
          i1 = ItemFactory.toItem(s.next());          
          i2 = player2.play(); 
          player2.considerOpponentItem(i1); // NEW
        } catch (InvalidInputException e) {
          System.out.println(e);
          System.out.println(howto);
        }
      } while (i1 == null || i2 == null);
      System.out.println("You selected " + i1); 
      System.out.println("Your computer opponent selected " + i2); 
      if (i1.beats(i2)) {
        System.out.println("You win");  
        result = GameResult.P1WON;
      } else if (i2.beats(i1)) {
        System.out.println("You loose");
        result = GameResult.P2WON;
      } else {
        System.out.println("Nobody wins");
        result = GameResult.TIE;
      }
    } while (result != GameResult.P1WON && result != GameResult.P2WON);
  }
}