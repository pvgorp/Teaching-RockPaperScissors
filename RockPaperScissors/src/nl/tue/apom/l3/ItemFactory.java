package nl.tue.apom.l3;

import nl.tue.apom.l3.items.*;

public class ItemFactory {
  public static Item toItem(String input) throws InvalidInputException {
    if (input.equalsIgnoreCase("rock")) {
      return new Rock();
    } else if (input.equalsIgnoreCase("paper")) {
      return new Paper();
    } else if (input.equalsIgnoreCase("scissors")) {
      return new Scissors();
    } else {
      throw new InvalidInputException(input); 
    }
  }
}
