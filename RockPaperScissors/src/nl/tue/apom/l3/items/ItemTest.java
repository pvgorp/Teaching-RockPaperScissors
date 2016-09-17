package nl.tue.apom.l3.items;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ItemTest {

  final static Rock r1= new Rock();
  final static Rock r2= new Rock();
  
  final static Scissors s1= new Scissors();
  final static Scissors s2= new Scissors();
  
  final static Paper p1= new Paper();
  final static Paper p2= new Paper();

  @Test
  public void testRockRock() {
    assertThat(r1.beats(r2), equalTo(false)); 
  }
  
  @Test
  public void testRockScissors() {
    assertThat(r1.beats(s1), equalTo(true)); 
  }
  
  @Test
  public void testRockPaper() {
    assertThat(r1.beats(p1), equalTo(false)); 
  }
  
  @Test
  public void testScissorsScissors() {
    assertThat(s1.beats(s1), equalTo(false)); 
  }

  @Test
  public void testScissorsPaper() {
    assertThat(s1.beats(p1), equalTo(true)); 
  }
  
  @Test
  public void testScissorsRock() {
    assertThat(s1.beats(r1), equalTo(false)); 
  }
  
  @Test
  public void testPaperPaper() {
    assertThat(p1.beats(p2), equalTo(false)); 
  }
  
  @Test
  public void testPaperScissors() {
    assertThat(p1.beats(s1), equalTo(false)); 
  }
  
  @Test
  public void testPapeRock() {
    assertThat(p1.beats(r1), equalTo(true)); 
  }
}

