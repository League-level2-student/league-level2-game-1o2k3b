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

	public void pay() {
		Player tempPlay = Board.players.get(whichPlayer);
		Property tempProp = ((Property) Board.tiles.get(tempPlay.currentTile));
		tempPlay.money -= tempProp.cost/8;
		 Board.players.get(tempProp.owner).money += tempProp.cost/8;
		JOptionPane.showMessageDialog(null, "you paid " + Board.players.get(tempProp.owner).name + " $" + tempProp.cost/8 + " because you landed on " + tempProp.name);
	}

	public void purchase() {
		String checker = JOptionPane
				.showInputDialog("would you like to buy " + Board.names[Board.players.get(whichPlayer).currentTile]);
		if (checker.equalsIgnoreCase("yes")) {
			Player tempPlay = Board.players.get(whichPlayer);
			Property tempProp = ((Property) Board.tiles.get(tempPlay.currentTile));
			if (tempPlay.money > tempProp.cost) {
				tempProp.owner = whichPlayer;
				tempPlay.money -= tempProp.cost;
				tempPlay.properties.add(tempProp);
			}
		}
	}

	public void updateWhichPlayer() {
		// TODO Auto-generated method stub
		whichPlayer++;
		whichPlayer %= 4;
	}
}
