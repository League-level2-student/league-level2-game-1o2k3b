package monopolyPackage;

import java.util.Random;

import javax.swing.JOptionPane;

public class Turn {
	static Random r = new Random();
	static int whichPlayer = 0;

	static public void roll() {

		// roll of the dice

		Board.players.get(whichPlayer).currentTile += r.nextInt(9) + 2;

		Board.players.get(whichPlayer).currentTile %= 36;


	}

	public void purchase() {
		String checker = JOptionPane.showInputDialog("would you like to buy " + Board.names[Board.players.get(whichPlayer).currentTile]);
		if(checker.equalsIgnoreCase("yes")) {
			((Property)Board.tiles.get(Board.players.get(whichPlayer).currentTile)).owner = whichPlayer;
			System.out.println(((Property)Board.tiles.get(Board.players.get(whichPlayer).currentTile)).owner);
		}
	}

	public void updateWhichPlayer() {
		// TODO Auto-generated method stub
		whichPlayer++;
		whichPlayer %= 4;	
	}
}
