package monopolyPackage;

import java.util.Random;

public class Turn {
	static Random r = new Random();
static int whichPlayer = 0;
static public void roll() {
	
	//roll of the dice

Board.players.get(whichPlayer).currentTile+=r.nextInt(9)+2;

	Board.players.get(whichPlayer).currentTile%=36;	

	whichPlayer++;
whichPlayer%=4;


}
}
