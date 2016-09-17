package nl.tue.apom.l3.items;

public class Scissors implements Item {
  @Override
  public boolean beats(Item other) {
    return other instanceof Paper;
  }
  public String toString() {
    return "SCISSORS";
  }
}
