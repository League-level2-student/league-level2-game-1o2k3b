package monopolyPackage;

import java.util.Random;

public class Turn {
	Random r = new Random();
int whichPlayer = 0;
public void roll() {
	
	//roll of the dice
Board.players.get(whichPlayer).currentTile+=r.nextInt(9)+2;
	
	
	
	
	whichPlayer++;
whichPlayer%=4;


}
}
