package nl.tue.apom.l3.ai;

import nl.tue.apom.l3.items.Item;

public interface AutomaticPlayer {
  public Item play();
  
  public void considerOpponentItem(Item itemOfOther);
}
