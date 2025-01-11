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
		tempPlay.money -= tempProp.cost / 8;
		Board.players.get(tempProp.owner).money += tempProp.cost / 8;
		JOptionPane.showMessageDialog(null, "you paid " + Board.players.get(tempProp.owner).name + " $"
				+ tempProp.cost / 8 + " because you landed on " + tempProp.name);
	}

	public void chance() {
		Player tempPlay = Board.players.get(whichPlayer);
		int check = r.nextInt(9) + 1;
		if (check < 4) {
			tempPlay.money -= check * 30;
			JOptionPane.showMessageDialog(null, "oh no! you lost $" + check*30);
		}
		if (3 < check && check < 7) {
			for (int i = 0; i < 4; i++) {
				if (i != whichPlayer) {
					Board.players.get(i).money -= 20;
				}
			}
			JOptionPane.showMessageDialog(null, "congrats! you stole $20 from everyone, and gained 60$");
			tempPlay.money += 60;
		}
		if (check > 6) {
			tempPlay.money += (check-6) * 50;
			JOptionPane.showMessageDialog(null, "congrats! you gained $" + (check-6) *50);
		}
	}

	public void chest() {
		Player tempPlay = Board.players.get(whichPlayer);
		int check = r.nextInt(9) + 1;
		if (check < 4) {
			tempPlay.money -= check * 30;
			JOptionPane.showMessageDialog(null, "oh no! you lost $" + check*30);
		}
		if (3 < check && check < 7) {
			String chooser = JOptionPane.showInputDialog("choose who to steal 50 dollars from, enter 1, 2, 3, or 4");
			int choose = Integer.parseInt(chooser);
			choose-=1;
			Board.players.get(choose).money-=50;
			tempPlay.money+=50;
			JOptionPane.showMessageDialog(null, "congrats! you stole $50 from " + (choose+1));
		}
		if (check > 6) {
			tempPlay.money += (check-6) * 50;
			JOptionPane.showMessageDialog(null, "congrats! you gained $" + (check-6) *50);
		}
	}

	public void purchase() {
//		String checker = JOptionPane
//				.showInputDialog("would you like to buy " + Board.names[Board.players.get(whichPlayer).currentTile]);
//		
		
		int choice = JOptionPane.showConfirmDialog(null, "would you like to buy " + Board.names[Board.players.get(whichPlayer).currentTile], "", JOptionPane.YES_NO_OPTION);
	
		
		
		if (choice == 0) {
			Player tempPlay = Board.players.get(whichPlayer);
			Property tempProp = ((Property) Board.tiles.get(tempPlay.currentTile));
			if (tempPlay.money > tempProp.cost) {
				tempProp.owner = whichPlayer;
				tempPlay.money -= tempProp.cost;
				tempPlay.properties.add(tempProp);
			} 
		} else {
			JOptionPane.showMessageDialog(null, "ok, fine, dont buy my overpriced real estate");
		}
	}

	public void updateWhichPlayer() {
		// TODO Auto-generated method stub
		whichPlayer++;
		whichPlayer %= 4;
	}
//TODO: split this into the two tax methods..
	public void incomeTax() {
		System.out.println("tax");
		Player tempPlay = Board.players.get(whichPlayer);
			tempPlay.money-=200;
			JOptionPane.showMessageDialog(null, "you landed on income tax and paid $200 for it");
	}
	public void luxuryTax() {
		Player tempPlay = Board.players.get(whichPlayer);
			tempPlay.money-=100;
			JOptionPane.showMessageDialog(null, "you landed on luxury tax and paid $100 for it");
	}
}

